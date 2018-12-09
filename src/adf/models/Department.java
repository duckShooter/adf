package adf.models;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.commons.codec.digest.DigestUtils;

public class Department implements Serializable {
	private int id;
	private String name;
	private Timestamp createdAt;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	public static void main(String[] args) {
		System.out.println(DigestUtils.sha1Hex("Hello")); //Test
		System.out.println(DigestUtils.sha1Hex("Hello")); //Test
	}
}
