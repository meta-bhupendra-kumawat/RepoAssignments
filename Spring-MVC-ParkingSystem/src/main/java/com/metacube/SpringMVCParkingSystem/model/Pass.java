package com.metacube.SpringMVCParkingSystem.model;

public class Pass {
	
//	private int id;
	private String type;
	private double daily;
	private double monthly;
	private double yearly;
	
	public Pass() {
	}
	
	public Pass(String type, double daily, double monthly, double yearly) {
		super();
//		this.id = id;
		this.type = type;
		this.daily = daily;
		this.monthly = monthly;
		this.yearly = yearly;
	}
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDaily() {
		return daily;
	}

	public void setDaily(double daily) {
		this.daily = daily;
	}

	public double getMonthly() {
		return monthly;
	}

	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}

	public double getYearly() {
		return yearly;
	}

	public void setYearly(double yearly) {
		this.yearly = yearly;
	}
	
}
