package com.simple_servelet_project.signup;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/login";
			String user ="root";
			String password ="root";
			
			Connection connection = DriverManager.getConnection(url, user, password);
			String userdetail = "select userName,pass from logintable where username=? and password = ?";
			PreparedStatement preparedStatement	 = connection.prepareStatement(userdetail);
			preparedStatement.setString(1, un);
			preparedStatement.setString(2, pw);
			
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				resp.sendRedirect("sucess.jsp");
				
			}
			resp.sendRedirect("error.jsp");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


	
}
