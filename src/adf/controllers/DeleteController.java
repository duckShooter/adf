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

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	public void processRequest(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if(action != null) {
			switch(action) {
			case "doDeleteUser":
				deleteUser(req);
				//req.getServletContext().getRequestDispatcher("/users").forward(req,resp);
				resp.sendRedirect("users");
				break;
			case "doDeleteDept":
				deleteDepartment(req);
				//req.getServletContext().getRequestDispatcher("/departments").forward(req, resp);
				resp.sendRedirect("departments");
				break;
			case "doDeleteFolder":
				deleteFolder(req);
				//req.getServletContext().getRequestDispatcher("/folders").forward(req, resp);
				resp.sendRedirect("folders");
				break;
			case "doDeleteOfficer":
				deleteOfficer(req);
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
	
	private void deleteUser(HttpServletRequest req) throws SQLException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement DeleteUserQuery = con.prepareStatement("DELETE FROM \"TEST\".\"ADMIN\" WHERE ID = ?");
		DeleteUserQuery.setInt(1, id);
		DeleteUserQuery.executeUpdate();
		con.commit();
		con.close();
	}
	
	private void deleteDepartment(HttpServletRequest req) throws SQLException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement DeleteDeptQuery = con.prepareStatement("DELETE FROM \"TEST\".\"DEPT\" WHERE ID = ?");
		DeleteDeptQuery.setInt(1, id);
		DeleteDeptQuery.executeUpdate();
		con.commit();
		con.close();
	}
	
	private void deleteFolder(HttpServletRequest req) throws SQLException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement DeleteFolderQuery = con.prepareStatement("DELETE FROM \"TEST\".\"FOLDER\" WHERE ID = ?");
		DeleteFolderQuery.setInt(1, id);
		DeleteFolderQuery.executeUpdate();
		con.commit();
		con.close();
	}
	
	private void deleteOfficer(HttpServletRequest req) throws SQLException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		Connection con = DatabaseConnection.getActiveConnection();
		PreparedStatement DeleteOfficerQuery = con.prepareStatement("DELETE FROM \"TEST\".\"ACCOUNT\" WHERE ID = ?");
		DeleteOfficerQuery.setInt(1, id);
		DeleteOfficerQuery.executeUpdate();
		con.commit();
		con.close();
	}

}
