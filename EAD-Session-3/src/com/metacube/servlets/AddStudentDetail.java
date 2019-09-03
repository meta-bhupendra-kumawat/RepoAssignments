package com.metacube.servlets;
import DAO.StudentDAO;

import com.metacube.other.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentDetail
 */
public class AddStudentDetail extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = SQLConnection.getConnection();
		PrintWriter out = response.getWriter();
		try {
			String firstName = request.getParameter("first_name");
			String lastName = request.getParameter("last_name");
			String fatherName = request.getParameter("father_name");
			String email = request.getParameter("email");
			int className = Integer.parseInt(request.getParameter("class"));
			int age = Integer.parseInt(request.getParameter("age"));
			
			Student s = new Student(firstName, lastName, fatherName, email, className, age);
			StudentDAO std = new StudentDAO();
			String message = std.addStudent(s);
			System.out.println(message);
			response.setContentType("text/html");
			out.println("<h2 align=\"center\">" + message + "</h2><br>");
			out.println("<div id=\"main\" align=\"center\"> "
					+ "<h3><a href=\"addStudent.html\">Add Student</a></h3> "
							+ "<h3><a href=\"./showAllStudent\">Show All Student</a></h3> "
									+ "<h3><a href=\"SearchStudent.html\">Search Student</a></h3> "
											+ "<br>"
											+ "</div>");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
