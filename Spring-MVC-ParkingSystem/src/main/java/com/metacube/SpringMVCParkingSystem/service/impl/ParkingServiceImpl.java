package com.metacube.SpringMVCParkingSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.metacube.SpringMVCParkingSystem.dao.ParkingDao;
import com.metacube.SpringMVCParkingSystem.dto.EditEmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.EmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.VehicleDto;
import com.metacube.SpringMVCParkingSystem.model.Employee;
import com.metacube.SpringMVCParkingSystem.model.Pass;
import com.metacube.SpringMVCParkingSystem.model.Vehicle;
import com.metacube.SpringMVCParkingSystem.service.ParkingService;

@Controller
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	private ParkingDao parkingDao;
	
	@Override
	public List<Employee> findAllEmployees() {
		return parkingDao.getAllEmployees();
	}

	@Override
	public Employee findEmployeeByEmail(String email) {
		return parkingDao.findEmployeeByEmail(email);
	}

	@Override
	public boolean deleteEmployee(String email) {
		return parkingDao.deleteEmployee(email);
	}

	@Override
	public boolean updateEmployee(EditEmployeeDto employee) {
		return parkingDao.updateEmployee(employee);
	}

	@Override
	public boolean addEmployee(EmployeeDto employee) {
		return parkingDao.addEmployee(employee);
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return parkingDao.getAllVehicles();
	}

	@Override
	public Vehicle findVehicleByNumber(String vehicleNumber) {
		return parkingDao.findVehicleByNumber(vehicleNumber);
	}

	@Override
	public boolean deleteVehicle(String vehicleNumber) {
		return parkingDao.deleteVehicle(vehicleNumber);
	}

	@Override
	public boolean addVehicle(VehicleDto vehicle) {
		return parkingDao.addVehicle(vehicle);
	}

	@Override
	public List<Pass> getAllPassPrice() {
		return parkingDao.getAllPassPrice();
	}

	@Override
	public Pass getPassPriceByType(String type) {
		return parkingDao.getPassPriceByType(type);
	}

	@Override
	public boolean authenticateEmployee(String email, String password) {
		return parkingDao.authenticateEmployee(email, password);
	}

	@Override
	public List<Vehicle> findVehicleByOwner(String email) {
		return parkingDao.findVehicleByOwner(email);
	}

	@Override
	public double getVehiclePlan(String vehicleNumber) {
		return parkingDao.getVehiclePlan(vehicleNumber);
	}

	@Override
	public boolean getPlan(String price, String vehicleNumber) {
		return parkingDao.getPlan(price, vehicleNumber);
	}

	@Override
	public List<Employee> getAllFriends(String email, String company) {
		return parkingDao.getAllFriends(email, company);
	}

}
