package me.voyager.myworkspace.network;

public interface Call<T> {

	public boolean isSuccess();
	public T getContent();
	public void run(Listener<T> callback);
	
}
