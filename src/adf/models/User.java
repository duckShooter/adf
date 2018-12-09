package adf.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;

import adf.db.DatabaseConnection;

//One-To-Many
public class User implements Serializable {
	
	public enum Role {
		BOSS(0), OFFICER(1), ARCHIVE(2);
		private final int value;
		
		Role(int value) {
			this.value = value;
		}
		
		public int value() {
			return this.value;
		}
	}
	
	private int id;
	private String userName; //Required
	private String password; //Required
	private String rank; 
	private Role role; //Required
	private String fullName;
	private Department department; //Required
	private Timestamp createdAt;
	private Timestamp lastLogin;
	private String IPAddress;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getLastLogin() {
		return lastLogin;
	}


	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}


	public String getIPAddress() {
		return IPAddress;
	}


	public void setIPAddress(String iPAddress) {
		IPAddress = iPAddress;
	}


	public static void main(String[] args) throws SQLException {
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement stmt = con.prepareStatement("select * from tab");
		ResultSet result = stmt.executeQuery();
		//stmt.executeUpdate();
		ResultSetMetaData rmd = result.getMetaData();
		System.out.println(rmd.getColumnName(1) + " " + rmd.getColumnName(2) + " " + rmd.getColumnName(3));;
		while(result.next()) {
			System.out.println(result.getString(1) + " " +
					result.getString(2) + " " +
					result.getString(3) + " " );
		}
		//con.commit();
		con.close();
	}
}
