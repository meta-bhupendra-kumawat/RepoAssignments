package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import com.metacube.other.SQLConnection;
import com.metacube.other.Student;

public class StudentDAO {

	Connection con;
	Statement st;
	PreparedStatement prepStmt;
	public StudentDAO() {
		con = SQLConnection.getConnection(); 
		try {
			st = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String addStudent(Student s) {
		String query = "INSERT INTO student (first_name, last_name, father_name, email, class, age) "
				+ "VALUES(?, ?, ?, ?, ?, ?);";
		String message = "";
		try {
			prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, s.getFirstName());
			prepStmt.setString(2, s.getLastName());
			prepStmt.setString(3, s.getFatherName());
			prepStmt.setString(4, s.getEmail());
			prepStmt.setInt(5, s.getClassName());
			prepStmt.setInt(6, s.getAge());
			if(prepStmt.execute())
				message = "Student Added successfully!!";
		} catch(SQLIntegrityConstraintViolationException e1) {
			return "Email already exist.";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public ResultSet showAll() {
		ResultSet rs = null;
		String query = "SELECT * FROM Student;" ;
		try {
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet searchStudent(String firstName, String lastName, String className) {
		ResultSet rs = null;
		String query = "";
		if(firstName.equals("") && lastName.equals("") && className.equals("")) {
			query = "SELECT * FROM Student;" ;
		} else {
			if(firstName.equals("") && lastName.equals("")) {
				int classNo = Integer.parseInt(className);
				query = "SELECT * FROM Student "
						+ "WHERE class = " + classNo + ";";
			} else {
				if(lastName.equals("") && className.equals("")) {
					query = "SELECT * FROM Student " 
							+ "WHERE first_name = '" + firstName + "';";
				} else {
					if(firstName.equals("") && className.equals("")) {
						query = "SELECT * FROM Student "
								+ "WHERE last_name = '" + lastName + "';";
					}
					else {
						if(firstName.equals("")) {
							int classNo = Integer.parseInt(className);
							query = "SELECT * FROM Student "
									+ "WHERE last_name = '" + lastName + "' AND " 
									+ "class = " + classNo + "';";
						}
						if(lastName.equals("")) {
							int classNo = Integer.parseInt(className);
							query = "SELECT * FROM Student "
									+ "WHERE first_name = '" + firstName + "' AND "
									+ "class = " + classNo + "';";
						}
						if(className.equals("")) {
							query = "SELECT * FROM Student "
									+ "WHERE first_name = '" + firstName + "' AND "
									+ "last_name = '" + lastName + "';";
						} 
						if(!firstName.equals("") && !lastName.equals("") && !className.equals("")) {
							int classNo = Integer.parseInt(className);
							query = "SELECT * FROM Student "
									+ "WHERE first_name = '" + firstName + "' AND "
									+ "last_name = '" + lastName + "' AND " 
									+ "class = " + classNo + ";";
						}
					}
				}
			}
		}
		try {
			System.out.println("\n\n"+ query + " \n\n");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean updateStudent(Student s, int id) {
		String query = "UPDATE Student "
				+ "SET first_name = ?, last_name = ?, father_name = ?, email = ?, class = ?, age = ? "
				+ "WHERE Enrollment_No = ? ;";
		try {
			prepStmt = con.prepareStatement(query);
			prepStmt.setString(1, s.getFirstName());
			prepStmt.setString(2, s.getLastName());
			prepStmt.setString(3, s.getFatherName());
			prepStmt.setString(4, s.getEmail());
			prepStmt.setInt(5, s.getClassName());
			prepStmt.setInt(6, s.getAge());
			prepStmt.setInt(7, id);
			prepStmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}



