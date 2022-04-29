package me.voyager.myworkspace.model;

import java.security.Provider.Service;
import java.util.List;

import me.voyager.myworkspace.enums.Plataform;

public class Config {
	
	public Plataform plataform;
	public boolean isSincornized;
	public boolean isFirstUse = true;
	public String pathFileDataBase;
	public List<String> servicesInUse;
	
	public Plataform getPlataform() {
		return plataform;
	}
	public void setPlataform(Plataform plataform) {
		this.plataform = plataform;
	}
	public boolean isSincornized() {
		return isSincornized;
	}
	public void setSincornized(boolean isSincornized) {
		this.isSincornized = isSincornized;
	}
	public boolean isFirstUse() {
		return isFirstUse;
	}
	public void setFirstUse(boolean isFirstUse) {
		this.isFirstUse = isFirstUse;
	}
	public String getPathFileDataBase() {
		return pathFileDataBase;
	}
	public void setPathFileDataBase(String pathFileDataBase) {
		this.pathFileDataBase = pathFileDataBase;
	}
	
	
	
	
	
	
	
}
