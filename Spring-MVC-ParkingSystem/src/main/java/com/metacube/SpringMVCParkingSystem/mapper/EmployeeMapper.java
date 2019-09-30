package com.metacube.SpringMVCParkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.SpringMVCParkingSystem.model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setFullName(rs.getString("fullName"));
		employee.setGender(rs.getString("gender"));
		employee.setEmail(rs.getString("email"));
		employee.setPassword(rs.getString("password"));
		employee.setContact(rs.getString("contact"));
		employee.setCompany(rs.getString("company"));
		return employee;
	}
}
