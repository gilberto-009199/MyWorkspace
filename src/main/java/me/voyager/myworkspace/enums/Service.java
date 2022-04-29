package me.voyager.myworkspace.enums;

public enum Service {
	
	pCloud("pcloud"),
	oneDrive("onedrive"),
	gDrive("googledrive");
	
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
	
	public static Service stringByInstance(String serviceName) {
		
		for (Service service : Service.values() ) { 
		    if(service.getName().equals(serviceName))return service;
		}
		return null;
		
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	
}
