package com.jsp.simple_servlet_project_1pm.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.jsp.simple_servlet_project_1pm.dto.Employee;
import com.jsp.simple_servlet_project_1pm.service.EmployeeService;

public class RegisterController extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("username");
		String email = req.getParameter("email");
		long phone =   Long.parseLong(req.getParameter("phone"));
		String gender = req.getParameter("gender");
		
		System.out.println(name+"\n"+email+"\n"+phone+"\n"+gender);
		
		EmployeeService employeeService = new EmployeeService();
		
		Employee employee = new Employee();
		
		employee.setEmployeeId(id);
		employee.setEmployeeName(name);
		employee.setEmployeePhone(phone);
		employee.setEmployeeEmail(email);
		employee.setGender(gender);
		
		Employee employee2=employeeService.inserEmployee(employee);
		
		PrintWriter printWriter = res.getWriter();
		
		printWriter.write("<html><body>");
		
		if(employee2!=null) {
			
			printWriter.write("<h3 style='color:green'>Successfully....Stored</h3>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
			dispatcher.include(req, res);
			
		}else {
			printWriter.write("<h3 style='color:red'>Please Check Your Data</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("registration.jsp");
			dispatcher.include(req, res);
			
		}
		
		printWriter.write("</body></html>");
	}

}
