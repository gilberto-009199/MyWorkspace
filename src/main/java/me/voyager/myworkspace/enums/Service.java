package me.voyager.myworkspace.enums;

public enum Service {
	
	pCloud("pcloud"),
	oneDrive("OneDrive"),
	gDrive("GoogleDrive");
	
	private String name;
	
	Service(String name){
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
