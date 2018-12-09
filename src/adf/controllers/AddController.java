package adf.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import adf.db.DatabaseConnection;

@WebServlet("/add")
public class AddController extends HttpServlet {
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if(action != null) {
			switch(action) {
			case "doAddUser":
				addUser(req);
				//req.getServletContext().getRequestDispatcher("/users").forward(req,resp);
				resp.sendRedirect("users");
				break;
			case "doAddDept":
				addDepartment(req);
				//req.getServletContext().getRequestDispatcher("/departments").forward(req, resp);
				resp.sendRedirect("departments");
				break;
			case "doAddFolder":
				addFolder(req);
				//req.getServletContext().getRequestDispatcher("/folders").forward(req, resp);
				resp.sendRedirect("folders");
				break;
			case "doAddOfficer":
				addOfficer(req);
				//req.getServletContext().getRequestDispatcher("/officers").forward(req, resp);
				resp.sendRedirect("officers");
				break;
			default:
				return;
			}
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processRequest(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			processRequest(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void addDepartment(HttpServletRequest req) throws SQLException {
		String deptName;
		if((deptName = req.getParameter("name")) != null) {
			Connection con = DatabaseConnection.getActiveConnection();
			PreparedStatement addDeptQuery = con.prepareStatement("INSERT INTO \"TEST\".\"DEPT\" (NAME) VALUES (?)");
			addDeptQuery.setString(1, deptName);
			addDeptQuery.executeUpdate();
			con.commit();
			con.close();
			
		};
		
	}
	
	private void addUser(HttpServletRequest req) throws SQLException {
		String userRank;
		String fullname;
		String username;
		String password;
		if((userRank = req.getParameter("rank")) != null && (fullname = req.getParameter("fullname")) != null && (username = req.getParameter("username")) != null && (password = req.getParameter("password")) != null) {
			Connection con = DatabaseConnection.getActiveConnection();
			PreparedStatement addUserQuery = con.prepareStatement("INSERT INTO \"TEST\".\"ADMIN\" (RANK , FULLNAME , USERNAME , PASSWORD , CREATED_UPDATED_AT) VALUES ( ? , ? , ? , ? , ? )");
			addUserQuery.setString(1, userRank);
			addUserQuery.setString(2, fullname);
			addUserQuery.setString(3, username);
			addUserQuery.setString(4, DigestUtils.sha1Hex(password));
			addUserQuery.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
			addUserQuery.executeUpdate();
			con.commit();
			con.close();
		};
	}
	
	private void addFolder(HttpServletRequest req) throws SQLException {
		String name;
		int year = new GregorianCalendar().get(Calendar.YEAR);
		if((name = req.getParameter("name")) != null) {
			Connection con = DatabaseConnection.getActiveConnection();
			PreparedStatement addFolderQuery = con.prepareStatement("INSERT INTO \"TEST\".\"FOLDER\" (FOLD_NAME , FOLD_DATE) VALUES ( ? , ? )");
			addFolderQuery.setString(1, name);
			addFolderQuery.setInt(2, year);
			addFolderQuery.executeUpdate();
			con.commit();
			con.close();
		};
	}
	
	private void addOfficer(HttpServletRequest req) throws SQLException {
		String username, fullname, rank, password;
		int role, dept;
		if((username = req.getParameter("username")) != null &&
		(fullname = req.getParameter("fullname")) != null &&
		(password = req.getParameter("password")) != null &&
		(rank = req.getParameter("rank")) != null &&
		req.getParameter("role") != null &&
		req.getParameter("dept") != null) {
			role = Integer.parseInt(req.getParameter("role"));
			dept = Integer.parseInt(req.getParameter("dept"));
			
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement addOfficerQuery = con.prepareStatement("INSERT INTO \"TEST\".\"ACCOUNT\" (USERNAME, PASSWORD, FULLNAME, CREATED_UPDATED_AT, RANK, DEPT_ID, ROLE)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)" );
		addOfficerQuery.setString(1, username);
		addOfficerQuery.setString(2, DigestUtils.sha1Hex(password));
		addOfficerQuery.setString(3, fullname);
		addOfficerQuery.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
		addOfficerQuery.setString(5, rank);
		addOfficerQuery.setInt(6, dept);
		addOfficerQuery.setInt(7, role);
		
		addOfficerQuery.executeUpdate();
		con.commit();
		con.close();
		}
	}

}
