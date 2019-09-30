package facade;

import java.util.List;

import dao.EmployeeDAO;
import dto.Company;
import dto.Employee;

public class EmployeeFacade {

	private static EmployeeFacade employeeFacade = null;

	public static EmployeeFacade getInstance(){

		if(employeeFacade == null){
			employeeFacade = new EmployeeFacade();
		}
		return employeeFacade;
	}

	public int getEmployeeId(String email)throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getEmployeeId(email);
		}catch(Exception e){
			throw e;
		}
	}
	public int addEmployee(Employee employee,Company company) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.addEmployee(employee,company);
		}catch(Exception e){
			throw e;
		}
	}
	public Employee getEmployeeDetail(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getEmployeeDetail(email);
		}catch(Exception e){
			throw e;
		}
	}

	public Employee getFriendDetail(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getFriendDetail(email);
		}catch(Exception e){
			throw e;
		}
	}

	public boolean updateEmployeeDetail(Employee employee,String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.updateEmployeeDetail(employee,email);
		}catch(Exception e){
			throw e;
		}
	}

	public List<Employee> getFriendList(String email) throws Exception{

		EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
		try{
			return employeeDAO.getFriendList(email);
		}catch(Exception e){
			throw e;
		}
	}

	public boolean isVehicleRegistrationComplete(String email) throws Exception{

		VehicleFacade vehicleFacade = VehicleFacade.getInstance();
		try{
			if(vehicleFacade.getVehicleId(email) > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw e;
		}
	}

	public boolean isPlanRegistrationComplete(String email) throws Exception{

		PlanFacade planFacade = PlanFacade.getInstance();
		try{
			if(planFacade.getPlanId(email) > 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			throw e;
		}
	}
}
