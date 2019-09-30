package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Company;
import dto.Employee;
import facade.EmployeeFacade;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Employee employee = new Employee();
		Company company = new Company();
		
		employee.setName(request.getParameter("name"));
		employee.setGender(request.getParameter("gender"));
		employee.setEmail(request.getParameter("email"));
		employee.setPassword(request.getParameter("password"));
		employee.setPhoneNumber(request.getParameter("contactnumber"));
		
		company.setId(Integer.parseInt(request.getParameter("organization")));
		HttpSession session = request.getSession();
		EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
		try{
			int employeeId = employeeFacade.addEmployee(employee,company);
			if(employeeId > -1){
				session.setAttribute("message","Welcome "+employee.getName()+" please login to continue");
				response.sendRedirect("jsp/login.jsp");
			}else{
				session.setAttribute("error","Registration failed");
				response.sendRedirect("jsp/employeeregister.jsp");
			}
		}catch(Exception e){
			
		}
		
	}

}
