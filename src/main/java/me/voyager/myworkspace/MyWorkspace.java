package me.voyager.myworkspace;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper;

import static java.lang.System.out;

import me.voyager.myworkspace.model.Config;
import me.voyager.myworkspace.model.MyFile;


public class MyWorkspace {
	/* preciso de uma arquivo de configuração e uma lista dos arquivos e um arquivo myworkspace de configuração na home do usuario */
	public List<MyFile> listFiles;
	public Config ConfigureLocal;
	
	public static String separator = System.getProperty("file.separator");
	public static String dirUser = new File(System.getProperty("user.home")).getAbsolutePath()+separator;
	public static String dirRuntime = "."+separator;
	public static String fileConfigRuntime = ".MyWorkspace";
	public static ObjectMapper mapper = new JavaPropsMapper();
	
	public static MyWorkspace build() {
		
		try {
			
			File configFile = null;
		
			Config myConfig = new Config();
		
			//getter config
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
			
			
			
			
			
		} catch (IOException e) {	out.print("Error read file"); e.printStackTrace();	
		} catch (Exception e) {	out.print("Error unknown"); e.printStackTrace();	}
		
		
		return null;
	}
	
	public void start() {
		
	}

}
