package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Employee;
import facade.EmployeeFacade;

/**
 * Servlet implementation class RedirectToEditPage
 */
@WebServlet("/RedirectToEditPage")
public class RedirectToEditPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectToEditPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		
		EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
		try{
			Employee employee = employeeFacade.getEmployeeDetail(email);
			session.setAttribute("employeeDetail", employee);
			response.sendRedirect("jsp/private/updateemployeedetails.jsp");
		}catch(Exception e){
			session.setAttribute("error","Unable to retrive details");
			response.sendRedirect("jsp/private/employeehome.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
