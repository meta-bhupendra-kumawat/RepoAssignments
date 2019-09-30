package facade;

import dao.VehicleDAO;
import dto.Vehicle;

public class VehicleFacade {

	private static VehicleFacade vehicleFacade = null;

	public static VehicleFacade getInstance(){

		if(vehicleFacade == null){
			vehicleFacade = new VehicleFacade();
		}
		return vehicleFacade;
	}

	public boolean addVehicle(Vehicle vehicle, int empId) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			return vehicleDAO.addVehicle(vehicle,empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	
	public int getVehicleId(String email) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
			int empId = employeeFacade.getEmployeeId(email);
			return vehicleDAO.getVehicleId(empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	public String getVehicleType(String email) throws Exception{

		VehicleDAO vehicleDAO = VehicleDAO.getInstance();
		try{
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
			int empId = employeeFacade.getEmployeeId(email);
			return vehicleDAO.getVehicleType(empId);
		}catch(Exception e){
			throw e;
		}
	}
}
