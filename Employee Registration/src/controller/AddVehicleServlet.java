package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Vehicle;
import facade.VehicleFacade;

/**
 * Servlet implementation class AddVehicleServlet
 */
@WebServlet("/AddVehicleServlet")
public class AddVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setName(request.getParameter("vehiclename"));
		vehicle.setType(request.getParameter("vehicletype"));
		vehicle.setNumber(request.getParameter("vehiclenumber"));
		vehicle.setIdentification(request.getParameter("identification"));
		int empId = Integer.parseInt(request.getParameter("empid"));
		
		HttpSession session = request.getSession();
		VehicleFacade vehicleFacade = VehicleFacade.getInstance();
		try{
			boolean result = vehicleFacade.addVehicle(vehicle,empId);
			if(result){
				request.setAttribute("vehicleType", vehicle.getType());
				RequestDispatcher rd = request.getRequestDispatcher("RedirectToPlanRegistrationPage");
				rd.forward(request, response);
			}else{
				session.setAttribute("error", "Vehicle not added");
				RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
				rd.forward(request, response);
			}
		}catch(Exception e){
			session.setAttribute("error", "Vehicle not added");
			RequestDispatcher rd = request.getRequestDispatcher("LogoutServlet");
			rd.forward(request, response);
		}
		
	}

}
