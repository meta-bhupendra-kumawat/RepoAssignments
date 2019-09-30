package com.metacube.SpringMVCParkingSystem.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import com.metacube.SpringMVCParkingSystem.dao.ParkingDao;
import com.metacube.SpringMVCParkingSystem.dto.EditEmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.EmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.VehicleDto;
import com.metacube.SpringMVCParkingSystem.mapper.EmployeeMapper;
import com.metacube.SpringMVCParkingSystem.mapper.LoginMapper;
import com.metacube.SpringMVCParkingSystem.mapper.PriceMapper;
import com.metacube.SpringMVCParkingSystem.mapper.VehicleMapper;
import com.metacube.SpringMVCParkingSystem.model.Employee;
import com.metacube.SpringMVCParkingSystem.model.Pass;
import com.metacube.SpringMVCParkingSystem.model.Vehicle;

@Controller
public class ParkingDaoImpl implements ParkingDao{

	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_FIND_EMPLOYEE = "SELECT * FROM employee WHERE email = ?";
	private final String SQL_DELETE_EMPLOYEE = "DELETE FROM employee WHERE email = ?";
	private final String SQL_UPDATE_EMPLOYEE = "UPDATE employee SET fullName = ?, gender = ?, password = ?, contact = ?, company = ? where email = ?";
	private final String SQL_GET_ALL_EMPLOYEE = "SELECT * FROM employee";
	private final String SQL_INSERT_EMPLOYEE = "INSERT INTO employee(email, fullname, gender, password, contact, company) values(?,?,?,?,?,?)";
	private final String SQL_AUTHENTICATE_EMPLOYEE = "SELECT email FROM employee WHERE email = ? AND password = ?";
	private final String SQL_GET_ALL_EMPLOYEE_FRIENDS = "SELECT * FROM employee WHERE company = ? AND email != ? ";
	
	private final String SQL_FIND_VEHICLE = "SELECT * FROM vehicle WHERE vehicleNumber = ?";
	private final String SQL_FIND_VEHICLE_BY_OWNER = "SELECT * FROM vehicle WHERE email = ?";
	private final String SQL_DELETE_VEHICLE = "DELETE FROM vehicle WHERE vehicleNumber = ?";
	private final String SQL_GET_ALL_VEHICLE = "SELECT * FROM vehicle";
	private final String SQL_INSERT_VEHICLE = "INSERT INTO vehicle(email, name, type, vehicleNumber, identification) values(?,?,?,?,?)";
	private final String SQL_FIND_VEHICLE_PLAN_PRICE = "SELECT planPrice FROM vehicle where vehicleNumber = ?";
	private final String SQL_UPDATE_VEHICLE_PLAN = "UPDATE vehicle SET planPrice = ? where vehicleNumber = ?";

	private final String SQL_GET_PASS_PRICE = "SELECT * FROM pass WHERE type = ?";
	
	private final String SQL_GET_ALL_PASS_PRICE = "SELECT * FROM pass";
	
	@Autowired
	public ParkingDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean addEmployee(EmployeeDto employee) {
		return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getEmail(), employee.getFullName(), employee.getGender(),
				employee.getPassword(), employee.getContact(), employee.getCompany()) > 0;
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] { email }, new EmployeeMapper());
	}

	@Override
	public boolean updateEmployee(EditEmployeeDto employee) {
		return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getFullName(), employee.getGender(), employee.getPassword(), employee.getContact(), 
				employee.getCompany(), employee.getEmail()) > 0;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return jdbcTemplate.query(SQL_GET_ALL_EMPLOYEE, new EmployeeMapper());
	}

	@Override
	public boolean deleteEmployee(String email) {
		return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, email) > 0;
	}

	@Override
	public boolean addVehicle(VehicleDto vehicle) {
		return jdbcTemplate.update(SQL_INSERT_VEHICLE, vehicle.getEmail(), vehicle.getName(), vehicle.getType(), 
				vehicle.getVehicleNumber(), vehicle.getIdentification()) > 0;
	}

	@Override
	public Vehicle findVehicleByNumber(String vehicleNumber) {
		return jdbcTemplate.queryForObject(SQL_FIND_VEHICLE, new Object[] { vehicleNumber }, new VehicleMapper());
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return jdbcTemplate.query(SQL_GET_ALL_VEHICLE, new VehicleMapper());
	}

	@Override
	public boolean deleteVehicle(String vehicleNumber) {
		return jdbcTemplate.update(SQL_DELETE_VEHICLE, vehicleNumber) > 0;
	}

	@Override
	public Pass getPassPriceByType(String type) {
		return jdbcTemplate.queryForObject(SQL_GET_PASS_PRICE, new Object[] { type }, new PriceMapper());
	}

	@Override
	public boolean authenticateEmployee(String email, String password) {
			List<Employee> e = jdbcTemplate.query(SQL_AUTHENTICATE_EMPLOYEE, new Object[] {email, password}, new LoginMapper());
			if(e.size() > 0 && e.get(0).getEmail().equals(email))
				return true;
			else
				return false;
	}

	@Override
	public List<Pass> getAllPassPrice() {
		return jdbcTemplate.query(SQL_GET_ALL_PASS_PRICE, new PriceMapper());
	}

	@Override
	public List<Vehicle> findVehicleByOwner(String email) {
		return jdbcTemplate.query(SQL_FIND_VEHICLE_BY_OWNER, new Object[] { email }, new VehicleMapper());
	}

	@Override
	public double getVehiclePlan(String vehicleNumber) {
		return jdbcTemplate.queryForObject(SQL_FIND_VEHICLE_PLAN_PRICE, new Object[] { vehicleNumber }, Double.class);
	}

	@Override
	public boolean getPlan(String price, String vehicleNumber) {
		return jdbcTemplate.update(SQL_UPDATE_VEHICLE_PLAN, price, vehicleNumber) > 0;
	}

	@Override
	public List<Employee> getAllFriends(String email, String company) {
		return jdbcTemplate.query(SQL_GET_ALL_EMPLOYEE_FRIENDS, new Object[] {company, email}, new EmployeeMapper());
	}
}
