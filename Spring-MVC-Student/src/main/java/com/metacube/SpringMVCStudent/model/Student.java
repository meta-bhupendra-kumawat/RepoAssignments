package com.metacube.SpringMVCStudent.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * This is a POJO class. This class stores hard-coded data of students.
 * @author Bhupendra.
 */
public class Student {

	@NotBlank(message = "{firstName.notBlank}")
	@Size(min = 2, max =  15,message = "{firstName.Size}")
	@Pattern(regexp = "^[A-Za-z]+$", message = "{firstName.alphabetsOnly}")
	private String firstName;
	
	@NotBlank(message = "{lastName.NotBlank}")
	@Size(min = 2, max =  15,message = "Name must be between {min} and {max}")
	@Pattern(regexp = "^[A-Za-z]+$", message = "{lastName.alphabetsOnly}")
	private String lastName;
	
	@NotBlank(message = "{fatherName.NotBlank}")
	@Size(min = 2, max =  15,message = "Name must be between {min} and {max}")
	private String fatherName;
	
	@NotBlank(message = "{email.notBlank}")
	@Email(message = "{email.validateEmail}")
	private String email;
	
	@NotBlank(message = "{studentClass.notBlank}")
	@Pattern(regexp = "^[1-9]|1[0-2]$", message = "{studentClass.onlyNumber}")
	private String studentClass;
	
	@NotBlank(message = "{age.notBlank}")
	@Pattern(regexp = "^[4-9]|[1-9][0-9]$", message = "{age.onlyNumber}")
	private String age;
	
	// Default constructor.
	public Student() {
		
	}
	
	// Parameterised constructor.
	public Student(String firstName, String lastName, String fatherName, String email, String studentClass, String age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
	}
	
	// Getters and Setters.
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
}
