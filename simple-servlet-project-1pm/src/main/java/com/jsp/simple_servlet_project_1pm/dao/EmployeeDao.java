package com.jsp.simple_servlet_project_1pm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jsp.simple_servlet_project_1pm.connection.JdbcConnection;
import com.jsp.simple_servlet_project_1pm.dto.Employee;

public class EmployeeDao {

	// insert Method to save the employee details
	public Employee inserEmployee(Employee employee) {

		Connection connection = JdbcConnection.getConnection();

		String insertEmployeeQuery = "insert into employee values(?,?,?,?,?)";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(insertEmployeeQuery);

			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getEmployeeName());
			preparedStatement.setString(3, employee.getEmployeeEmail());
			preparedStatement.setLong(4, employee.getEmployeePhone());
			preparedStatement.setString(5, employee.getGender());

			preparedStatement.execute();

			return employee;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int deleteById(int id) {

		Connection connection = JdbcConnection.getConnection();

		String deleteEmployeeQuery = "delete from  employee where empid=?";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployeeQuery);

			preparedStatement.setInt(1, id);

			int id1 = preparedStatement.executeUpdate();

			return id1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public int updateEmployee(Employee employee) {

		Connection connection = JdbcConnection.getConnection();

		String updateEmployeeQuery = null;
		PreparedStatement preparedStatement=null;

		if ((employee.getEmployeeName() != null) && (employee.getEmployeeEmail() != null)
				&& (employee.getEmployeePhone() != 0) && (employee.getGender() != null)) {

			updateEmployeeQuery = "update employee set empname=?, empemail=?, empphone=?, empgender=? where empid=?";

			
			try {
				preparedStatement = connection.prepareStatement(updateEmployeeQuery);
				preparedStatement.setInt(5, employee.getEmployeeId());
				preparedStatement.setString(1, employee.getEmployeeName());
				preparedStatement.setString(2, employee.getEmployeeEmail());
				preparedStatement.setLong(3, employee.getEmployeePhone());
				preparedStatement.setString(4, employee.getGender());

				return preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} else if((employee.getEmployeeName() != null) && (employee.getEmployeeEmail() != null) && (employee.getEmployeePhone() != 0)) {
			updateEmployeeQuery = "update employee set empname=?, empemail=?, empphone=? where empid=?";

			try {
				
				preparedStatement = connection.prepareStatement(updateEmployeeQuery);
				preparedStatement.setInt(4, employee.getEmployeeId());
				preparedStatement.setString(1, employee.getEmployeeName());
				preparedStatement.setString(2, employee.getEmployeeEmail());
				preparedStatement.setLong(3, employee.getEmployeePhone());
				
				return preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else if((employee.getEmployeeName() != null) && (employee.getEmployeeEmail() != null)) {
			updateEmployeeQuery = "update employee set empname=?, empemail=? where empid=?";

			try {
				
				preparedStatement = connection.prepareStatement(updateEmployeeQuery);
				preparedStatement.setInt(3, employee.getEmployeeId());
				preparedStatement.setString(1, employee.getEmployeeName());
				preparedStatement.setString(2, employee.getEmployeeEmail());
				
				return preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
			
			updateEmployeeQuery = "update employee set empname=? where empid=?";

			System.out.println("else part");
			try {
				
				preparedStatement = connection.prepareStatement(updateEmployeeQuery);
				preparedStatement.setInt(2, employee.getEmployeeId());
				preparedStatement.setString(1, employee.getEmployeeName());
				
				return preparedStatement.executeUpdate();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		return 0;
	}
	
	//display method for Employee
	public List<Employee> getEmployees(){
		
		Connection connection = JdbcConnection.getConnection();
		
		String selectQueryEmployee = "Select *  from employee";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectQueryEmployee);
			
			ResultSet resultSet=preparedStatement.executeQuery();
	
			List<Employee> employees = new ArrayList<Employee>();
			
		    while(resultSet.next()) {
		    	
		    	Employee employee = new Employee();
		    	
		    	employee.setEmployeeId(resultSet.getInt("empid"));
		    	employee.setEmployeeName(resultSet.getString("empname"));
		    	employee.setEmployeeEmail(resultSet.getString("empemail"));
		    	employee.setEmployeePhone(resultSet.getLong("empphone"));
		    	employee.setGender(resultSet.getString("empgender"));
		    	
		    	employees.add(employee);
		    }
			
		    return employees;
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
