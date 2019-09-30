package com.metacube.SpringMVCParkingSystem.dao;

import java.util.List;

import com.metacube.SpringMVCParkingSystem.dto.EditEmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.EmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.VehicleDto;
import com.metacube.SpringMVCParkingSystem.model.Employee;
import com.metacube.SpringMVCParkingSystem.model.Pass;
import com.metacube.SpringMVCParkingSystem.model.Vehicle;

public interface ParkingDao {
	
	public boolean addEmployee(EmployeeDto employee);
	
	public Employee findEmployeeByEmail(String email);
	
	public boolean updateEmployee(EditEmployeeDto employee);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleteEmployee(String email);
	
	public boolean authenticateEmployee(String email, String password);
	
	
	
	public boolean addVehicle(VehicleDto vehicle);

	public Vehicle findVehicleByNumber(String vehicleNumber);

	public List<Vehicle> getAllVehicles();

	public boolean deleteVehicle(String vehicleNumber);
	
	
	public List<Pass> getAllPassPrice();
	
	public Pass getPassPriceByType(String type);

	public List<Vehicle> findVehicleByOwner(String email);

	public double getVehiclePlan(String vehicleNumber);

	public boolean getPlan(String price, String vehicleNumber);

	public List<Employee> getAllFriends(String email, String company);

}
