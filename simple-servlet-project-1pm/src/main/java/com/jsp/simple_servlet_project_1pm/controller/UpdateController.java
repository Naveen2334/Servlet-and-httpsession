package com.jsp.simple_servlet_project_1pm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.simple_servlet_project_1pm.dto.Employee;
import com.jsp.simple_servlet_project_1pm.service.EmployeeService;

public class UpdateController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		long phone =   Long.parseLong(req.getParameter("phone"));
		String gender = req.getParameter("gender");
		
		EmployeeService employeeService = new EmployeeService();
		
		Employee employee = new Employee();
		employee.setEmployeeName(name);
		if(phone==0l) {
			employee.setEmployeePhone(phone);
		}
		
		employee.setEmployeeEmail(email);
		employee.setGender(gender);
		employee.setEmployeeId(id);
		
		int id1=employeeService.updateEmployee(employee);
		
		
		if(id1!=0) {
			
		}else {
			
		}
		
		
	}
}
