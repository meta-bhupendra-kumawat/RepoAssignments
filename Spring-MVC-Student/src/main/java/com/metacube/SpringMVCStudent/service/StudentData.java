package com.metacube.SpringMVCStudent.service;

import java.util.ArrayList;
import java.util.List;

import com.metacube.SpringMVCStudent.model.Student;

public class StudentData {

	// instance variables.
	static List<Student> data = new ArrayList<Student>();
	
	// Static block for initializing data list.
	static {
		Student s;
		
		s = new Student("Shahrukh", "Khan", "Badshah", "Shahrukh@khann.com", "2", "23");
		data.add(s);
		s = new Student("Salman", "Khan", "Badshah", "Salman@khann.com", "12", "20");
		data.add(s);
		s = new Student("Ranbir", "kapoor", "Badshah", "Ranbir@kapoor.com", "5", "31");
		data.add(s);
		s = new Student("Shahid", "kapoor", "Badshah", "Shahid@kapoor.com", "12", "21");
		data.add(s);
		s = new Student("Ranbir", "Singh", "Badshah", "Ranbir@Singh.com", "4", "13");
		data.add(s);
		s = new Student("Raju", "Khandelwal", "Badshah", "Raju@Khandelwal.com", "5", "23");
		data.add(s);
	}
	
	// This method returns student's data as list.
	public static List<Student> getStudents() {
		return data;
	}
}
