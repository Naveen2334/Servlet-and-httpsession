package com.jsp.servlet_httpsession_1pm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();

		String name = req.getParameter("userName");
		String email = req.getParameter("userEmail");

		PrintWriter printWriter = resp.getWriter();
		
		printWriter.write("<html><body>");
		if ((name.equalsIgnoreCase("root")) && (email.equalsIgnoreCase("root@123"))) {

			httpSession.setAttribute("myName", name);

			RequestDispatcher dispatcher = req.getRequestDispatcher("userprofile.jsp");

			dispatcher.forward(req, resp);

		} else {
			printWriter.write("<h3>Please check your credentials</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");

			dispatcher.include(req, resp);
		}
		printWriter.write("</body></html>");
	}

}
