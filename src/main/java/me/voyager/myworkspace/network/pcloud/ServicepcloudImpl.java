package me.voyager.myworkspace.network.pcloud;

import static java.lang.System.out;

import java.io.File;
import java.io.IOException;

import com.pcloud.sdk.ApiClient;
import com.pcloud.sdk.Authenticators;
import com.pcloud.sdk.Callback;
import com.pcloud.sdk.PCloudSdk;
import com.pcloud.sdk.RemoteEntry;
import com.pcloud.sdk.RemoteFolder;

import me.voyager.myworkspace.MyWorkspace;
import me.voyager.myworkspace.model.MyFile;
import me.voyager.myworkspace.network.Call;
import me.voyager.myworkspace.network.Connect;

//https://my.pcloud.com/oauth2/authorize?client_id=UklIetAHe0f&response_type=code
//https://my.pcloud.com/oauth2/authorize?client_id=UklIetAHe0f&response_type=token
//https://api.pcloud.com/oauth2_token?client_id=UklIetAHe0f&client_secret=
// get code for page, post code in code url
//https://api.pcloud.com/oauth2_token?client_id=UklIetAHe0f&client_secret=&code=

public class ServicepcloudImpl implements Connect {
	
	public MyWorkspace workspace;
	public pCloudConfig config;
	public ApiClient apiClient;
	public static String fileConfigRuntime = ".MypCloud";
	
	public ServicepcloudImpl(MyWorkspace workspace) {
		this.workspace = workspace;
	}
	

	public boolean start() {

		try {

			// get config
			File configFile = null;
		
			config = new pCloudConfig();
			//myConfig.servicesInUse = Arrays.asList("pcloud","onedrive");
			
			if(new File(workspace.dirRuntime + fileConfigRuntime).exists()) {//./
				configFile = new File(workspace.dirRuntime + fileConfigRuntime);
			}else if(new File(MyWorkspace.dirUser + workspace.fileConfigRuntime).exists()) {// $home
				configFile = new File(MyWorkspace.dirUser + fileConfigRuntime);
			} else { // create 
				configFile = new File(MyWorkspace.dirUser + fileConfigRuntime);
				workspace.mapper.writerFor(config.getClass()).writeValue(configFile, config);
			}
			// Create File or Read File 
			if( configFile.length() == 0 ) workspace.mapper.writerFor(config.getClass()).writeValue(configFile, config);
			else config = workspace.mapper.readerFor(config.getClass()).readValue(configFile, config.getClass());
			
			// verify config.isFirstUse
			// test connect
			apiClient = PCloudSdk.newClientBuilder()
	                	//.authenticator(Authenticators.newOAuthAuthenticator(""))
	                	.create();
			
			/*com.pcloud.sdk.Call<RemoteFolder> remoteFolder  = apiClient.listFolder(RemoteFolder.ROOT_FOLDER_ID);
			System.out.println( "Enviar: " );
			remoteFolder.enqueue(new Callback<RemoteFolder>() {
				@Override
				public void onResponse(com.pcloud.sdk.Call<RemoteFolder> call, RemoteFolder response) {
					System.out.println( "Voltou: " );
					for( RemoteEntry dir : response.children() ) {
						System.out.println( dir.name() );
					}
				}
				@Override
				public void onFailure(com.pcloud.sdk.Call<RemoteFolder> call, Throwable t) {}
			});*/
			
			//remoteFolder.isExecuted();
			
			
		} catch (IOException e) {	out.print("Error read file"); e.printStackTrace();	
		} catch (Exception e) {	out.print("Error unknown"); e.printStackTrace();	}

		
		return false;
	}

	public Call<MyFile> upload() {
		return null;
	}

	public Call<MyFile> download() {
		return null;
	}

	public Call<MyFile> delete() {
		return null;
	}

}
