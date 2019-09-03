package com.metacube.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.other.SQLConnection;

/**
 * Servlet implementation class Temp
 */
public class Temp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = SQLConnection.getConnection();
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		int className = Integer.parseInt(request.getParameter("class"));
		
		System.out.println(">"+firstName+"<");
		System.out.println(">"+lastName+"<");
		System.out.println(">"+className+"<");
	}
}
