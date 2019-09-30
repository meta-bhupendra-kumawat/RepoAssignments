package com.metacube.SpringMVCParkingSystem.dto;

import javax.validation.constraints.NotBlank;

public class EditEmployeeDto {
	
	@NotBlank
	private String fullName;
	@NotBlank
	private String gender;
	@NotBlank
	private String email;
	@NotBlank
	private String password;
	@NotBlank
	private String contact;
	@NotBlank
	private String company;
	
	// Getters and setters.
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
}
