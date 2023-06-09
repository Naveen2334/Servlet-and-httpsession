package com.jsp.simple_servlet_project_1pm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.simple_servlet_project_1pm.service.EmployeeService;

public class DeleteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		EmployeeService employeeService = new EmployeeService();
		
		employeeService.deleteById(id); 
	}
}
