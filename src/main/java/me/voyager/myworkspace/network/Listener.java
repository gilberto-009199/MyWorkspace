package me.voyager.myworkspace.network;

public interface Listener<T> {
	public void run(T content);
}
