package me.voyager.myworkspace;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;


import me.voyager.myworkspace.model.Config;
import me.voyager.myworkspace.model.MyFile;
import me.voyager.myworkspace.network.Connect;
import me.voyager.myworkspace.network.pcloud.ServicepcloudImpl;
import me.voyager.myworkspace.enums.*;

import static java.lang.System.out;

public class MyWorkspace {
	/* preciso de uma arquivo de configuração e uma lista dos arquivos e um arquivo myworkspace de configuração na home do usuario */
	public List<MyFile> listFiles;
	public Config configureLocal;
	
	public static String separator = System.getProperty("file.separator");
	public static String dirUser = new File(System.getProperty("user.home")).getAbsolutePath()+separator;
	public static String dirRuntime = "."+separator;
	public static String fileConfigRuntime = ".MyWorkspace";
	public static ObjectMapper mapper = new JavaPropsMapper();
	
	public static MyWorkspace build() {
		
		MyWorkspace workspace = null;
		
		try {
			
			File configFile = null;
		
			Config myConfig = new Config();
			//myConfig.servicesInUse = Arrays.asList("pcloud","onedrive");
			
			if(new File(dirRuntime + fileConfigRuntime).exists()) {//./
				configFile = new File(dirRuntime + fileConfigRuntime);
			}else if(new File(MyWorkspace.dirUser + fileConfigRuntime).exists()) {// $home
				configFile = new File(MyWorkspace.dirUser + fileConfigRuntime);
			} else { // create 
				configFile = new File(MyWorkspace.dirUser + fileConfigRuntime);
				mapper.writerFor(Config.class).writeValue(configFile, myConfig);
			}

			// Create File or Read File 
			if( configFile.length() == 0 ) mapper.writerFor(Config.class).writeValue(configFile, myConfig);
			else myConfig = mapper.readerFor(Config.class).readValue(configFile, myConfig.getClass());
			
			
			workspace = new MyWorkspace(myConfig);
			
		} catch (IOException e) {	out.print("Error read file"); e.printStackTrace();	
		} catch (Exception e) {	out.print("Error unknown"); e.printStackTrace();	}
		
		
		return workspace;
	}
	
	public void start() {
		// Read Service Backup
		for( String serviceName : configureLocal.servicesInUse ) {
			// connect
			Connect com = null;
			
			switch (Service.stringByInstance(serviceName)) {
				case pCloud:
					com = new ServicepcloudImpl(this);
					break;
				case oneDrive:
					break;
				case gDrive:
					break;
				default:
					break;
			}
			
			if( com != null && com.start()) {
				out.println("Servico carregado!!!");
			};
			
		}
		
		
	}

	private MyWorkspace() {}
	private MyWorkspace(Config configureLocal) {
		this.configureLocal = configureLocal;
	}
	private MyWorkspace(Config configureLocal, List<MyFile> listFiles) {
		this.configureLocal = configureLocal;
		this.listFiles = listFiles;
	}
}
