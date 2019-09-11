package com.metacube.SpringMVCStudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.SpringMVCStudent.model.Student;
import com.metacube.SpringMVCStudent.service.StudentData;

/**
 * This is a controller class.
 * @author Bhupendra
 */
@Controller
public class StudentController {
	
	@Value("${home.message}")
	String welcomeMessage;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", welcomeMessage);
		return "home";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("studentObject", student);
		return "addStudent";
	}
	
	@PostMapping("/submit")
	public String saveStudent(@Validated @ModelAttribute("studentObject") Student student, BindingResult result ) {
		if(result.hasErrors())
			return "addStudent";
		return "redirect:showAll";
	}
	
	@GetMapping("/showAll") 
	public String showStudents(Model model) {
		List<Student> data = StudentData.getStudents();
		model.addAttribute("data", data);
		return "showAll";
	}
}
