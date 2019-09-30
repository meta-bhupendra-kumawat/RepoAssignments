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
 * Servlet implementation class ShowFriendDetailServlet
 */
@WebServlet("/ShowFriendDetailServlet")
public class ShowFriendDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFriendDetailServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = request.getParameter("email");

		EmployeeFacade employeeFacade = EmployeeFacade.getInstance();
		try{
			Employee employee = employeeFacade.getFriendDetail(email);
			session.setAttribute("friendDetail", employee);
			response.sendRedirect("jsp/private/friendprofile.jsp");
		}catch(Exception e){
			session.setAttribute("error","Unable to retrive friends details");
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
		}
	}

}
