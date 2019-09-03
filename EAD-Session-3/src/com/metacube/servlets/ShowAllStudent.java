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
import com.metacube.other.Student;

/**
 * Servlet implementation class ShowAllStudent
 */
public class ShowAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = SQLConnection.getConnection();
		PrintWriter out = response.getWriter();
		StudentDAO std = new StudentDAO();
		System.out.println("Show All Student servlet called!!");
		
		String id = request.getParameter("id");
		if(id == null) {
			ResultSet rs = std.showAll();
			int count = 0;		
			out.println("<table align='center' cellspacing ='30'> " + "<tr> "
					+ "<th>Enrollment Id</th>" + "<th>First Name</th>" + "<th>Last Name</th>" 
					+ "<th>Father Name</th>" + "<th>Email</th>" + "<th>Class</th>"
					+ "<th>Age</th>" + "<th>Actions</th>" + "</tr>" );
			try {
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
							+ rs.getInt("age") 
							+ "</td>" 
							+ "<td>"
							+ "<a href='updateStudent.html?id=" + rs.getInt("Enrollment_No") 
							+ "&first_name=" + rs.getString("first_name")
							+ "&last_name=" + rs.getString("last_name")
							+ "&father_name=" + rs.getString("father_name")
							+ "&email=" + rs.getString("email")
							+ "&class=" + rs.getInt("class")
							+ "&age=" + rs.getInt("age")
							+ "'>Update</a>" 
							+ "</td>"
							+ "</tr>" );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(count == 0)
				out.println("<h3>No Data found!</h3>");
			out.println("</table>");
		} else {
			// Update the given student.
			int Enrollment_id = Integer.parseInt(id);
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String fatherName = request.getParameter("father_name");
			String email = request.getParameter("email");
			int className = Integer.parseInt(request.getParameter("class"));
			int age = Integer.parseInt(request.getParameter("age"));
			
			Student s = new Student(firstName, lastName, fatherName, email, className, age);
			if(std.updateStudent(s, Enrollment_id)) {
				System.out.println("Student Added successfully!!");
				response.setContentType("text/html");
				out.println("<h3 allign=\"center\">Student Updated successfully!!</h3>");
				out.println("<div id=\"main\" align=\"center\"> "
						+ "<a href=\"index.html\">Home</a><br><br> "
												+ "</div>");
			}
		}
	}
}
