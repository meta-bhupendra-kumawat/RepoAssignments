package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Employee;
import facade.EmployeeFacade;
import facade.LoginFacade;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		employee.setEmail(request.getParameter("email"));
		employee.setPassword(request.getParameter("password"));
		
		LoginFacade loginFacade = new LoginFacade();
		HttpSession session = request.getSession();
		try{
			boolean result = loginFacade.login(employee);
			if(result){
				session.setAttribute("email", employee.getEmail());
				EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
				boolean isVehicleRegistered = employeeFacade.isVehicleRegistrationComplete(employee.getEmail());
				if(isVehicleRegistered){
					boolean isPlanRegistered = employeeFacade.isPlanRegistrationComplete(employee.getEmail());
					if(isPlanRegistered){
						RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
						rd.forward(request, response);
					}else{
						RequestDispatcher rd = request.getRequestDispatcher("RedirectToPlanRegistrationPage");
						rd.forward(request, response);
					}
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("RedirectToVehicleRegistrationPage");
					rd.forward(request, response);
				}
			}else{
				session.setAttribute("error","Login failed");
				response.sendRedirect("jsp/login.jsp");
			}
		}catch(Exception e){
			session.setAttribute("error","Login failed");
			response.sendRedirect("jsp/login.jsp");
		}
		
	}

}
