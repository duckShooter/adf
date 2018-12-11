package adf.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import adf.db.DatabaseConnection;
import adf.models.Admin;

@SuppressWarnings("serial")
@WebServlet(name="validate",
urlPatterns="/validate")
public class Validation extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
		req.setCharacterEncoding("UTF-8"); //Recommended
		resp.setCharacterEncoding("UTF-8"); //Recommended
		
		HttpSession session = req.getSession(false);
		//Invalidate old session before authentication
		if(session != null) {
			System.out.println("Old Session Has Been Invalidated.");
			session.invalidate();
		}
		
		//Create a new session
		session = req.getSession(true);
		session.setMaxInactiveInterval(60*60*24*7); //7 Days [Review]
		
		
		Admin admin = new Admin(); //Represents the current user
		
		//Retrieve login credentials from login page
		String username = req.getParameter("username");
		String password =  DigestUtils.sha1Hex(req.getParameter("password"));
		
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement stmt = con.prepareStatement("select * from admin where USERNAME = ? AND PASSWORD = ?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet res = stmt.executeQuery();
		System.out.println("FROM:" + Validation.class.getCanonicalName());
		System.out.println("User:" + username + "  -  SHA-1 HEX: " + password);
		
		//Validate login credentials
		if(!res.next()){ //Check if empty (move the cursor)
			System.out.println("Resultset is Empty");
			resp.sendRedirect("a?error=1");
		} else {
			System.out.println("CORRECT CREDENTIALS");
			admin.setId(res.getInt(1));
			admin.setUsername(res.getString(2));
			admin.setPassword(res.getString(3));
			admin.setFullname(res.getString(4));
			
		
			session.setAttribute("admin", admin);
			session.setAttribute("isLoggedIn", true);
			SessionControl.saveSession(req, resp);
			resp.sendRedirect("a/dashboard");
		}
		
		con.close();
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
	
	public static void main(String[] args) {
		System.out.println(Validation.class.getCanonicalName());
	}
}
