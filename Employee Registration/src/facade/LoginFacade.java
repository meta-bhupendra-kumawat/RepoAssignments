package facade;

import dao.LoginDAO;
import dto.Employee;

public class LoginFacade {

	private static LoginFacade loginFacade = null;
	
	public static LoginFacade getInstance(){
		
		if(loginFacade == null){
			loginFacade = new LoginFacade();
		}
		return loginFacade;
	}
	
	/**
	 * This method authenticate user details 
	 * @param user object of User class
	 * @return true if user details are correct else false
	 */
	public boolean login(Employee employee) throws Exception{
		
		LoginDAO loginDAO = LoginDAO.getInstance();
		try{
		 return loginDAO.login(employee);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
