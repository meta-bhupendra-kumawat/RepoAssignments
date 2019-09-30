package com.metacube.SpringMVCParkingSystem.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.SpringMVCParkingSystem.model.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehicle vehicle = new Vehicle();
		vehicle.setEmail(rs.getString("email"));
		vehicle.setVehicleNumber(rs.getString("vehicleNumber"));
		vehicle.setName(rs.getString("name"));
		vehicle.setType(rs.getString("type"));
		vehicle.setIdentification(rs.getString("identification"));
		return vehicle;
	}
}
