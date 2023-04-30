package com.jsp.simple_servlet_project_1pm.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.simple_servlet_project_1pm.dto.Employee;
import com.jsp.simple_servlet_project_1pm.service.EmployeeService;

public class DisplayEmployeeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeService employeeService = new EmployeeService();
		
		List<Employee> employees=employeeService.getEmployees();
		
		PrintWriter printWriter = resp.getWriter();
		
		printWriter.write("<html>");
		
		printWriter.write("<head><link rel='stylesheet' href='css/employee.css'/></head><body>");
		
		printWriter.write("<table border='1px'>");
		
		printWriter.write("<tr><th>empId</th><th>empName</th><th>empEmail</th><th>empPhone</th><th>empGender</th></tr>");
		
		for (Employee employee : employees) {
			
			printWriter.write("<tr>");
			
			printWriter.write("<td>"+employee.getEmployeeId()+"</td>");
			printWriter.write("<td>"+employee.getEmployeeName()+"</td>");
			printWriter.write("<td>"+employee.getEmployeeEmail()+"</td>");
			printWriter.write("<td>"+employee.getEmployeePhone()+"</td>");
			printWriter.write("<td>"+employee.getGender()+"</td>");
			printWriter.write("</tr>");
			
		}
		
		printWriter.write("</table>");
		
		printWriter.write("</body></html>");
	}
}
