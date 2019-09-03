package com.metacube.other;

/* This is a POJO class. It maintains the data of Student object.
 * @author Bhupendra
 */
public class Student {
	// Instance variables.
	String firstName;
	String lastName;
	String fatherName;
	String email;
	int className;
	int age;
	
	// Constructor.
	public Student(String firstName, String lastName, String fatherName, String email, int className, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.className = className;
		this.age = age;
	}

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

	public int getClassName() {
		return className;
	}

	public void setClassName(int className) {
		this.className = className;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
