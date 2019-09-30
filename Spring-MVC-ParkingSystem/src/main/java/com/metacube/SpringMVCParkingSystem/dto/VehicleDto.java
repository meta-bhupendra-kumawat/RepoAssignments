package com.metacube.SpringMVCParkingSystem.dto;

import javax.validation.constraints.NotBlank;

public class VehicleDto {
	@NotBlank
	private String name;
	@NotBlank
	private String type;
	@NotBlank
	private String vehicleNumber;
	@NotBlank
	private String email;
	@NotBlank
	private String identification;
	
	// Getters and setters.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
