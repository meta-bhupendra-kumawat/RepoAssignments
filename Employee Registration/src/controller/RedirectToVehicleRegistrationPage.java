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

/**
 * Servlet implementation class RedirectToVehicleRegistrationPage
 */
@WebServlet("/RedirectToVehicleRegistrationPage")
public class RedirectToVehicleRegistrationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectToVehicleRegistrationPage() {
        super();
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
		
		EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		try {
			int empId = employeeFacade.getEmployeeId(email);
			session.setAttribute("employeeId", empId);
			response.sendRedirect("jsp/private/register/vehicleregister.jsp");
		} catch (Exception e) {
			session.setAttribute("error", "Can't get vehicle details");
			RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
			rd.forward(request, response);
		}
	}

}
