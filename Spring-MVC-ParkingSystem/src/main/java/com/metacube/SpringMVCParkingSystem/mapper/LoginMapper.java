package com.metacube.SpringMVCParkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.SpringMVCParkingSystem.model.Employee;

public class LoginMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee employee = new Employee();
		employee.setEmail(rs.getString("email"));
		return employee;
	}


}
