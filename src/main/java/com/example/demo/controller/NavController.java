package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.entity.Course;
@Controller
public class NavController {
	@GetMapping("/") 
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "Register";
	}

	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	@GetMapping("/createCourse")
	public String createCourse() {
		return "createCourse";
	}
	
	@GetMapping("/addlesson")
	public String addLesson() {
		return "addLesson";
	}
	@GetMapping("/trainerHome")
	public String trainerHome() {
		return "trainerHome";
	}
	@GetMapping("/studentHome")
	public String studentHome() {
		return "studentHome";
	}
	@GetMapping("/Course")
	public String Course() {
		return "Course";
	}
	@GetMapping("/myCourse")
	public String myCourse() {
		return "myCourse";
	}
//	@GetMapping("/purchase")
//	public String purchase() {
//		return "purchase";
//	}
	@GetMapping("/goToLesson")
	public String demoLesson() {
		return "demoLesson";
	}
	@GetMapping("/payment")
	public String payment(@RequestParam("price") long price,Model model)
	{
		Course c=new Course();
		c.setCoursePrice(price);
		System.out.println(c);
		model.addAttribute("cp",c);
		return "Payment";
	}
	@GetMapping("/getLessonOnly")
	public String demoCourse() {
		return "demoLesson";
	}
}
