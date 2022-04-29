package me.voyager.myworkspace.enums;

public enum Plataform {
	
	Linux("linux"),
	Windows("windows");
	
	private String name;
	
	Plataform(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
}
