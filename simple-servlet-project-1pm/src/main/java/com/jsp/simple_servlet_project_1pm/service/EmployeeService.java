package com.jsp.simple_servlet_project_1pm.service;

import java.util.List;

import com.jsp.simple_servlet_project_1pm.dao.EmployeeDao;
import com.jsp.simple_servlet_project_1pm.dto.Employee;

public class EmployeeService {
	
	EmployeeDao employeeDao = new EmployeeDao();

	// insert Method to save the employee details
	public Employee inserEmployee(Employee employee) {

		return employeeDao.inserEmployee(employee);
	}
	
	public int deleteById(int id) {
		return employeeDao.deleteById(id);
	}
	
	public int updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}
	
	public List<Employee> getEmployees(){
	
		return employeeDao.getEmployees();
	}
}
