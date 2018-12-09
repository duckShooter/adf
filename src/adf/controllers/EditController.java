package adf.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import adf.db.DatabaseConnection;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	
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
	
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if(action != null) {
			switch(action) {
			case "doEditOfficer":
				editOfficer(req);
				req.getServletContext().getRequestDispatcher("/officers").forward(req, resp);
				
				break;
			case "doEditDept":
				editDepartment(req);
				req.getServletContext().getRequestDispatcher("/departments").forward(req, resp);
				break;
			case "doEditFolder":
				editFolder(req);
				req.getServletContext().getRequestDispatcher("/folders").forward(req, resp);
				break;
			default:
				return;
			}
		}
	}
	
	private void editOfficer(HttpServletRequest req) throws SQLException {
		String username, fullname, rank, password;
		int id = Integer.parseInt(req.getParameter("id")), role, dept;
		if((username = req.getParameter("username")) != null &&
				(fullname = req.getParameter("fullname")) != null &&
				(password = req.getParameter("password")) != null &&
				(rank = req.getParameter("rank")) != null &&
				req.getParameter("role") != null &&
				req.getParameter("dept") != null) {
				role = Integer.parseInt(req.getParameter("role"));
				dept = Integer.parseInt(req.getParameter("dept")); 
				Connection con = DatabaseConnection.getActiveConnection();
				PreparedStatement editOfficerQuery;
				if(password.isEmpty() || password.length()==0 || password == null) {
					
					editOfficerQuery = con.prepareStatement("UPDATE \"TEST\".\"ACCOUNT\" SET USERNAME = ?, FULLNAME = ?, RANK = ?,"
							+ " DEPT_ID = ?, ROLE = ? WHERE ACCOUNT.ID = ?");
					editOfficerQuery.setString(1, username);
					System.out.println(username);
					editOfficerQuery.setString(2, fullname);
					System.out.println(fullname);
					editOfficerQuery.setString(3, rank);
					editOfficerQuery.setInt(4, dept);
					editOfficerQuery.setInt(5, role);
					editOfficerQuery.setInt(6, id);
				}
				else {
					editOfficerQuery = con.prepareStatement("UPDATE \"TEST\".\"ACCOUNT\" SET USERNAME = ?, PASSWORD = ?, FULLNAME = ?, RANK = ?,"
							+ " DEPT_ID = ?, ROLE = ? WHERE ACCOUNT.ID = ?");
					editOfficerQuery.setString(1, username);
					System.out.println("username");

					editOfficerQuery.setString(2, DigestUtils.sha1Hex(password));
					editOfficerQuery.setString(3, fullname);
					System.out.println("fullname");

					editOfficerQuery.setString(4, rank);
					editOfficerQuery.setInt(5, dept);
					editOfficerQuery.setInt(6, role);
					editOfficerQuery.setInt(7, id);
				}
					
				editOfficerQuery.executeUpdate();
				con.commit();
				con.close();
	}
	}
	
	private void editDepartment(HttpServletRequest req) throws SQLException {
		int id = Integer.parseInt(req.getParameter("id"));
		String deptName;
		if((deptName = req.getParameter("name")) != null) {
			Connection con = DatabaseConnection.getActiveConnection();
			PreparedStatement addDeptQuery = con.prepareStatement(" UPDATE test.dept set name = ? where dept.id = ?");
			addDeptQuery.setString(1, deptName);
			addDeptQuery.setInt(2, id);
			addDeptQuery.executeUpdate();
			con.commit();
			con.close();
		};
	}
	
	private void editFolder(HttpServletRequest req) throws SQLException {
		int id = Integer.parseInt(req.getParameter("id"));
		String folderName;
		if((folderName = req.getParameter("name")) != null) {
			Connection con = DatabaseConnection.getActiveConnection();
			PreparedStatement addDeptQuery = con.prepareStatement(" UPDATE test.folder set fold_name = ? where folder.id = ?");
			addDeptQuery.setString(1, folderName);
			addDeptQuery.setInt(2, id);
			addDeptQuery.executeUpdate();
			con.commit();
			con.close();
		};
		
		
	}
}
