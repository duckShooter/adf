package adf.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import adf.db.DatabaseConnection;
import adf.models.Admin;

@WebServlet(name="validate",
urlPatterns="/validate")
public class Validation extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, SQLException {
		HttpSession session = req.getSession();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
		Admin admin = new Admin();
		req.setCharacterEncoding("UTF-8"); //Recommended
		resp.setCharacterEncoding("UTF-8"); //Recommended
		String username = req.getParameter("username");
		String password =  DigestUtils.sha1Hex(req.getParameter("password"));
		
		/* TEST CODE
		session.setAttribute("user", username);
		session.setAttribute("pass", password);
		System.out.println(username);
		*/
		
		/* PROD CODE */
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement stmt = con.prepareStatement("select * from \"TEST\".\"ADMIN\" where USERNAME = ? AND PASSWORD = ?");
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet res = stmt.executeQuery();
		
		
		if(!res.next()){ //Check if empty (move the cursor)
			System.out.println("Resultset is Empty");
			resp.sendRedirect("login?error=1");
		} else {
			do { //loop over data
				//Retrieve the data for first row
				admin.setId(res.getInt(1));
				admin.setUsername(res.getString(2));
				admin.setPassword(res.getString(3));
				admin.setFullname(res.getString(4));
				admin.setRank(res.getString(9));
			} while(res.next());
			con.close();
			session.setAttribute("admin", admin);
			SessionControl.saveSession(req, resp);
			resp.sendRedirect("dashboard");
		}
		
		/*** if(res != null) {
			while(res.next()) {
				admin.setId(res.getInt(1));
				admin.setUsername(res.getString(2));
				admin.setPassword(res.getString(3));
			} 
			con.close();
			session.setAttribute("admin", admin);
		} else
			resp.sendRedirect("login?error=1");  **/
		
		//resp.sendRedirect("login?error=0");
		//requestDispatcher.forward(req, resp);
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
