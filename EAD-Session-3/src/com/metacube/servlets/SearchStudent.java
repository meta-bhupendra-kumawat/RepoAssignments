package com.metacube.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.StudentDAO;

import com.metacube.other.SQLConnection;

/**
 * Servlet implementation class SearchStudent
 */
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = SQLConnection.getConnection();
		PrintWriter out = response.getWriter();
		StudentDAO std = new StudentDAO();
		System.out.println("Search Student servlet called!!");

		int count = 0;
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String className = request.getParameter("class");

		ResultSet rs = std.searchStudent(firstName, lastName, className);
		try {
			out.println("<table align='center' cellspacing ='30'> " + "<tr> "
					+ "<th>Enrollment Id</th>" + "<th>First Name</th>" + "<th>Last Name</th>" 
					+ "<th>Father Name</th>" + "<th>Email</th>" + "<th>Class</th>"
					+ "<th>Age</th>" + "</tr>" );
			while (rs.next()) {
				count = 1;
				out.println("<tr> " + "<td>"
						+ rs.getInt("Enrollment_No")
						+ "</td>"
						+ "<td>"
						+ rs.getString("first_name")
						+ "</td>"
						+ "<td>"
						+ rs.getString("last_name")
						+ "</td>"
						+ "<td>"
						+ rs.getString("father_name")
						+ "</td>"
						+ "<td>"
						+ rs.getString("email")
						+ "</td>"
						+ "<td>"
						+ rs.getInt("class")
						+ "</td>"
						+ "<td>"
						+ rs.getInt("age") + "</td>" + "</tr>" );
			}
			out.println("</table>");
			
			if(count == 0) {
				out.println("<h4 align=\"center\">No such data found!!</h4>");
			}

			// while(rs.next()) {
			// System.out.println(rs.getInt("Enrollment_No"));
			// System.out.println(rs.getString("first_name"));
			// System.out.println(rs.getString("last_name"));
			// System.out.println(rs.getString("father_name"));
			// System.out.println(rs.getString("email"));
			// System.out.println(rs.getInt("class"));
			// System.out.println(rs.getInt("age"));
			// }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
