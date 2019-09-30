package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class RedirectToShowFriendsPage
 */
@WebServlet("/RedirectToShowFriendsPage")
public class RedirectToShowFriendsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectToShowFriendsPage() {
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
		List<Employee> friendList = new ArrayList<Employee>();
		try{
			friendList = employeeFacade.getFriendList(email);
			session.setAttribute("friendList", friendList);
			response.sendRedirect("jsp/private/employeefriends.jsp");
		}catch(Exception e){
			session.setAttribute("error","Can't get friend list");
			RequestDispatcher rd = request.getRequestDispatcher("ShowEmployeeDetailServlet");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
