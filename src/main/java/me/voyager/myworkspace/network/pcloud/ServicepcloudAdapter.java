package me.voyager.myworkspace.network.pcloud;

import me.voyager.myworkspace.model.MyFile;
import me.voyager.myworkspace.network.Call;
import me.voyager.myworkspace.network.Connect;

public class ServicepcloudAdapter implements Connect {

	public boolean start() {
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
