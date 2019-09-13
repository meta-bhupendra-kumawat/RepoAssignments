package com.metacube.SpringMVCParkingSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.SpringMVCParkingSystem.model.Employee;
import com.metacube.SpringMVCParkingSystem.model.Pass;
import com.metacube.SpringMVCParkingSystem.model.Vehicle;

@Controller
public class ParkingSystemController {
	
	@GetMapping("/index")
	public String home(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		List<String> companyList = new ArrayList<String>();
		companyList.add("Metacube");
		companyList.add("IBM");
		companyList.add("Google");
		model.addAttribute("companyList", companyList);
		
		return "index";
	}
	
	@PostMapping("/vehicleRegistration")
	public String vehicle(Model model) {
		Vehicle vehicle = new Vehicle();
		model.addAttribute("vehicle", vehicle);
		
		List<String> typeList = new ArrayList<String>();
		typeList.add("Cycle");
		typeList.add("MotorCycle");
		typeList.add("Four Wheelers");
		model.addAttribute("vehicleTypeList", typeList);
		
		return "vehicle";
	}
	
	@PostMapping("/getPass")
	public String getPass(Model model) {
		Pass pass = new Pass();
		model.addAttribute("pass", pass);
		return "pass";
	}
}
