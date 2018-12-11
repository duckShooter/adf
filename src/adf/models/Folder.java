package adf.models;

import java.io.Serializable;

public class Folder implements Serializable {
	private int id;
	private int name;
	private String year;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getName() {
		return name;
	}
	
	public void setName(int name) {
		this.name = name;
	}

	public String getDate() {
		return year;
	}
	
	public void setDate(String Date) {
		this.year = year;
	}
}
