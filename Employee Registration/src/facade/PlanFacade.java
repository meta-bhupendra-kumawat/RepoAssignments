package facade;

import dao.PlanDAO;
import dto.Plan;

public class PlanFacade {

	private static PlanFacade planFacade = null;

	public static PlanFacade getInstance(){

		if(planFacade == null){
			planFacade = new PlanFacade();
		}
		return planFacade;
	}
	
	public boolean addPlan(Plan plan ,int empId) throws Exception{
		
		PlanDAO planDAO = PlanDAO.getInstance();
		try{
			return planDAO.addPlan(plan,empId);
		}catch(Exception e){
			throw e;
		}
	}
	
	public int getPlanId(String email) throws Exception{
		
		PlanDAO planDAO = PlanDAO.getInstance();
		try{
			EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
			int empId = employeeFacade.getEmployeeId(email);
			return planDAO.getPlanId(empId);
		}catch(Exception e){
			throw e;
		}
	}
}
