package me.voyager.myworkspace.network;

import me.voyager.myworkspace.model.MyFile;

public interface Connect {
	
	public boolean start();
	public Call<MyFile> upload();
	public Call<MyFile> download();
	public Call<MyFile> delete();
	
}
