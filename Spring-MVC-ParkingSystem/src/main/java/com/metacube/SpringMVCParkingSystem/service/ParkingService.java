package com.metacube.SpringMVCParkingSystem.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.metacube.SpringMVCParkingSystem.dto.EditEmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.EmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.VehicleDto;
import com.metacube.SpringMVCParkingSystem.model.Employee;
import com.metacube.SpringMVCParkingSystem.model.Pass;
import com.metacube.SpringMVCParkingSystem.model.Vehicle;
@Component
public interface ParkingService {

	/**
	 * Method to get all employees
	 * @return list of employees
	 */
	public abstract List<Employee> findAllEmployees();
	
	/**
	 * Method to get employee by Id
	 * @param id id of a employee
	 * @return employee
	 */
	public abstract Employee findEmployeeByEmail(String email);
	
	
	/**
	 * Method to delete employee
	 * @param id id of a employee
	 * @return true or false
	 */
	public abstract boolean deleteEmployee(String email);
	
	
	/**
	 * Method update employee 
	 * @param employeeObj
	 * @return 
	 */
	public abstract boolean updateEmployee(EditEmployeeDto employeeObj);
	
	/**
	 * Method to add employee
	 * @param employee
	 * @return
	 */
	public abstract boolean addEmployee(EmployeeDto employee);
	
	
	
	
	/**
	 * Method to get all vehicles
	 * @return list of vehicles
	 */
	public abstract List<Vehicle> findAllVehicles();
	
	/**
	 * Method to get vehicle by Id
	 * @param id id of a vehicle
	 * @return vehicle
	 */
	public abstract Vehicle findVehicleByNumber(String vehicleNumber);
	
	/**
	 * Method to get vehicle by Id
	 * @param id id of a vehicle
	 * @return vehicle
	 */
	public abstract List<Vehicle> findVehicleByOwner(String email);
	
	/**
	 * Method to delete vehicle
	 * @param id id of a vehicle
	 * @return true or false
	 */
	public abstract boolean deleteVehicle(String vehicleNumber);
	
	/**
	 * Method to add vehicle
	 * @param vehicle
	 * @return
	 */
	public abstract boolean addVehicle(VehicleDto vehicle);
	
	
	/**
	 * Method to get all vehicles
	 * @return list of vehicles
	 */
	public abstract List<Pass> getAllPassPrice();
	
	/**
	 * Method to get vehicle by Id
	 * @param id id of a vehicle
	 * @return vehicle
	 */
	public abstract Pass getPassPriceByType(String type);
	
	/**
	 * Method to authenticate employee
	 * @param email
	 * @param password
	 * @return true if successfully authenticated, false otherwise
	 */
	public abstract boolean authenticateEmployee(String email, String password);

	/**
	 * Method to get vehicle plan
	 * @param vehicleNumber
	 * @return
	 */
	public abstract double getVehiclePlan(String vehicleNumber);

	/**
	 * Method to buy parking plan
	 * @param price
	 * @param vehicleNumber 
	 * @return 
	 */
	public abstract boolean getPlan(String price, String vehicleNumber);

	/**
	 * Method to find all friends of employee in a company.
	 * @param email
	 * @param company
	 * @return
	 */
	public abstract List<Employee> getAllFriends(String email, String company);
}
