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

/**
 * Servlet implementation class UpdateEmployeeDetailServlet
 */
@WebServlet("/UpdateEmployeeDetailServlet")
public class UpdateEmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		employee.setEmail(request.getParameter("email"));
		employee.setPassword(request.getParameter("password"));
		employee.setPhoneNumber(request.getParameter("contactnumber"));
		
		EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
		
		try{
			boolean result = employeeFacade.updateEmployeeDetail(employee,email);
			if(result){
				session.setAttribute("message","Update successful");
				session.setAttribute("email", employee.getEmail());
				RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
				rd.forward(request, response);
			}else{
				session.setAttribute("error","Update unsuccessful");
				RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
				rd.forward(request, response);
			}
		}catch(Exception e){
			session.setAttribute("error","Update unsuccessful");
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
			rd.forward(request, response);
		}
	}

}
