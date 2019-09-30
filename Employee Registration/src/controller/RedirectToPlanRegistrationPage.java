package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import facade.EmployeeFacade;
import facade.VehicleFacade;

/**
 * Servlet implementation class RedirectToPlanRegistrationPage
 */
@WebServlet("/RedirectToPlanRegistrationPage")
public class RedirectToPlanRegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectToPlanRegistrationPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
		VehicleFacade vehicleFacade = VehicleFacade.getInstance();
		String email = (String) session.getAttribute("email");
		try {
			int empId = employeeFacade.getEmployeeId(email);
			String vehicleType = vehicleFacade.getVehicleType(email);
			
			System.out.println(vehicleType);
			session.setAttribute("employeeId", empId);
			session.setAttribute("vehicleType",vehicleType);
			response.sendRedirect("jsp/private/register/planregister.jsp");
		} catch (Exception e) {
			session.setAttribute("error", "Can't get plan details");
			RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
			rd.forward(request, response);
		}
	}

}
