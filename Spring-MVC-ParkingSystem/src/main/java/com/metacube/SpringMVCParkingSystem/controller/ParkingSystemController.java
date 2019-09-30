package com.metacube.SpringMVCParkingSystem.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.SpringMVCParkingSystem.dto.EditEmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.EmployeeDto;
import com.metacube.SpringMVCParkingSystem.dto.LoginDto;
import com.metacube.SpringMVCParkingSystem.dto.PassDto;
import com.metacube.SpringMVCParkingSystem.dto.VehicleDto;
import com.metacube.SpringMVCParkingSystem.model.Employee;
import com.metacube.SpringMVCParkingSystem.model.Pass;
import com.metacube.SpringMVCParkingSystem.model.Vehicle;
import com.metacube.SpringMVCParkingSystem.service.ParkingService;

@Controller
public class ParkingSystemController {
	static List<String> companyList;
	static List<String> typeList;
	
	static {
		companyList = new ArrayList<String>();
		companyList.add("Metacube");
		companyList.add("IBM");
		companyList.add("Google");
		
		typeList = new ArrayList<String>();
		typeList.add("Cycle");
		typeList.add("MotorCycle");
		typeList.add("Four Wheelers");
	}
	
	@Autowired
	private ParkingService parkingService;
	
	@GetMapping("/login")
	public String login(Model model) {
		System.out.println("Get LOGIN");
		LoginDto login = new LoginDto();
		model.addAttribute("login", login);
		return "login";
	}
	
	@PostMapping("/login")
	public String postLogin(Model model, @Validated @ModelAttribute("login") LoginDto login, BindingResult result, HttpServletRequest request) {
	System.out.println("post login");	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		if(result.hasErrors()) {
			System.out.println("Has Errors");
			return "redirect:/login";
		} else {
			try {
				boolean success = parkingService.authenticateEmployee(login.getEmail(), login.getPassword());
				System.out.println(success);
				if(success) {
					HttpSession session = request.getSession();
					session.setAttribute("email", login.getEmail());
				}
				else {
					model.addAttribute("loginError", "Login credentials invalid!");
					return "/login";
				}
				
			} catch(Exception e) {
				e.printStackTrace();
				return "/login";
			}
		}
		
		List<Vehicle> vehiclesList = parkingService.findVehicleByOwner(login.getEmail());
		if(vehiclesList.size() <= 0) {
			return "redirect:/vehicleRegistration";
		}
		System.out.println("\n\nPass Price>>>>>" + parkingService.getVehiclePlan(vehiclesList.get(0).getVehicleNumber()));
		
		if(parkingService.getVehiclePlan(vehiclesList.get(0).getVehicleNumber()) < 0) {
			return "redirect:/getPass";
		}
		return "redirect:/profile"; // Redirects request to @GetMapping(/profile)
	}
	
	@GetMapping("/profile")
 	public String postProfile(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("email") == null)
			return "redirect:/login";
		
		String vehicleOwner = (String) request.getSession().getAttribute("email");
		List<Vehicle> vehiclesList = parkingService.findVehicleByOwner(vehicleOwner);
		if(vehiclesList.size() <= 0) {
			return "redirect:/vehicleRegistration";
		}
		System.out.println("\n\nPass Price>>>>>" + parkingService.getVehiclePlan(vehiclesList.get(0).getVehicleNumber()));
		
		if(parkingService.getVehiclePlan(vehiclesList.get(0).getVehicleNumber()) < 0) {
			return "redirect:/getPass";
		}
		
 		System.out.println("\n /profile");
 		Employee employee = parkingService.findEmployeeByEmail((String)request.getSession().getAttribute("email"));
 		System.out.println(employee.getFullName());
 		model.addAttribute("employee", employee);
 		model.addAttribute("companyList", companyList);
 		return "profile";
 	}
	
	@GetMapping("/editProfile")
	public String getUpdateProfile(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("email") == null)
			return "redirect:/login";
		Employee employee = parkingService.findEmployeeByEmail((String)request.getSession().getAttribute("email"));
 		System.out.println(employee.getFullName());
 		model.addAttribute("employee", employee);
 		model.addAttribute("companyList", companyList);
 		return "editProfile";
	}
	
 	@PostMapping("/editProfile")
 	public String updateProfile(Model model, @Validated  @ModelAttribute("employee")  EditEmployeeDto employeeObj, BindingResult result) {
 		
 		if(result.hasErrors())
 			System.out.println(result);
 		boolean success = parkingService.updateEmployee(employeeObj);
 		System.out.println("/updateProfile ->" + success);
 		if(success) {
 			model.addAttribute("employee", employeeObj);
 			return "redirect:/profile";
 		} else {
 			model.addAttribute("companyList", companyList);
 			return "editProfile";
 		}
 	}
	
	@GetMapping("/employeeRegistration")
	public String home(Model model) {
		
		EmployeeDto employee = new EmployeeDto();
		model.addAttribute("employee", employee);
		model.addAttribute("companyList", companyList);
		
		return "employee";
	}
	
	@PostMapping("/employeeRegistration")
	public String postHome(Model model, @Validated  @ModelAttribute("employee")  EmployeeDto employeeObj, BindingResult result) {
		
		if(result.hasErrors()) {
			model.addAttribute("companyList", companyList);
			return "employee";
		} else {
			try {
				boolean success = parkingService.addEmployee(employeeObj);
				if(success) {
					System.out.println("Employee registered successfully!!");
				}
				else {
					return "employee";
				}
			} catch (DataIntegrityViolationException e) {
				model.addAttribute("companyList", companyList);
				model.addAttribute("duplicateKeyError", "Email already registered!");
				System.out.println("Catched");
				return "employee";
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "redirect:/vehicleRegistration";
	}
	
	@GetMapping("/vehicleRegistration") 
	public String getVehicle(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("email") == null)
			return "redirect:/login";
		
		model.addAttribute("vehicle", new VehicleDto());
		model.addAttribute("vehicleTypeList", typeList);
		return "vehicle";
	}
	
	@PostMapping("/vehicleRegistration")
	public String vehicle(Model model, @Validated  @ModelAttribute("vehicle")  VehicleDto vehicleObj, BindingResult result, HttpServletRequest request) {
		model.addAttribute("email", request.getSession().getAttribute("email"));
		if(result.hasErrors()) {
			return "vehicle";
		} else {
			try {
				boolean success = parkingService.addVehicle(vehicleObj);
				if(success) {
					System.out.println("Vehicle Registered successfully");
				} else {
					model.addAttribute("vehicleTypeList", typeList);
					return "vehicle";
				}
			} catch(DataIntegrityViolationException e) {
				e.printStackTrace();
				model.addAttribute("vehicleTypeList", typeList);
				model.addAttribute("duplicateVehicleNumberError", "Vehicle with provided number already registered!");
				return "vehicle";
			}
		}
		return "redirect:/getPass";
	}
	
	@GetMapping("/getPass")
	public String getPass(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("email") == null)
			return "redirect:/login";
		
		String vehicleOwner = (String) request.getSession().getAttribute("email");
		List<Vehicle> vehiclesList = parkingService.findVehicleByOwner(vehicleOwner);
		if(vehiclesList.size() <= 0) {
			return "redirect:/vehicleRegistration";
		}
		System.out.println("\n\nPass Price>>>>>" + parkingService.getVehiclePlan(vehiclesList.get(0).getVehicleNumber()));
		
//		if(parkingService.getVehiclePlan(vehiclesList.get(0).getVehicleNumber()) < 0) {
//			return "redirect:/getPass";
//		}
		
		String email = (String) request.getSession().getAttribute("email");
		Vehicle vehicle = parkingService.findVehicleByOwner(email).get(0);
		String vehicleType = vehicle.getType();
		PassDto pass = new PassDto();
		model.addAttribute("pass", pass);
		
		System.out.println("/getPass vehicleType:" + vehicleType);
		Pass prices = parkingService.getPassPriceByType(vehicleType);
		model.addAttribute("priceList", new Pass(vehicleType, prices.getDaily(), prices.getMonthly(), prices.getYearly()));		
		return "pass";
	}
	
	@PostMapping("/getPass")
	public String postPass(Model model, @Validated @ModelAttribute("pass") PassDto passObj, HttpServletRequest request) {
		System.out.println("Post purchase pass");
		String email = (String) request.getSession().getAttribute("email");
		Vehicle vehicle = parkingService.findVehicleByOwner(email).get(0);
		String vehicleNumber = vehicle.getVehicleNumber();
		boolean success = parkingService.getPlan(passObj.getPrice(), vehicleNumber);
		
		System.out.println("Pass purchase =" + success +" Price =" + passObj.getPrice());
		
		if(success) {
			model.addAttribute("vehicleNumber", vehicleNumber);
			return "purchasedSuccessfully";
		} else {
			model.addAttribute("purchaseError", "Pass not available.");
			return "getPass";
		}
	}
	
	@GetMapping("/showFriends")
	public String showFriends(Model model, HttpServletRequest request) {
		if(request.getSession().getAttribute("email") == null)
			return "redirect:/login";
		String email = (String) request.getSession().getAttribute("email");
		String company = parkingService.findEmployeeByEmail(email).getCompany();
		List<Employee> friendList = parkingService.getAllFriends(email, company);
		model.addAttribute("friendList", friendList);
		Employee employeeFriend = new Employee();
		model.addAttribute("employeeFriend", employeeFriend);
		
		System.out.println("ShowFriends Size>" + friendList.size());
		return "friendsPage";
	}
	
	@PostMapping("/showFriendProfile")
	public String showFriendProfile(Model model, @ModelAttribute("employeeFriend")  EmployeeDto employeeFriend, BindingResult result) {
		Employee friend = parkingService.findEmployeeByEmail(employeeFriend.getEmail());
		model.addAttribute("friend", friend);
		return "/friendProfile";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();;
		System.out.println("Session Destroyed" + request.getSession());
		return "redirect:/login";
		}
}
