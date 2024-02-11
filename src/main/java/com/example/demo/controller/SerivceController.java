package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.CommentService;
import com.example.demo.Service.UserService;
import com.example.demo.entity.Users;
import com.example.demo.entity.Comments;
@Controller
public class SerivceController {
	@Autowired
	UserService uService;
	
	@Autowired
	CommentService cservice;

	@PostMapping("/addUser")
	public String addUser(@RequestParam("name")String name,
			@RequestParam("email")String email,
			@RequestParam("password")String password,
			@RequestParam("role")String role) {
		boolean eamilExists=uService.checkEmail(email);
		if(eamilExists==false) {
			Users usr=new Users();
			usr.setName(name);
			usr.setEmail(email);
			usr.setPassword(password);
			usr.setRole(role);
			uService.adduser(usr);
 
			System.out.println("User Registered Successfully");
			return "redirect:/login";
		}
		else {
			System.out.println("user already exist");
			return "redirect:/register";
		}

	}
	@PostMapping("/validate")
	public String validate(
			@RequestParam("email")String email,
			@RequestParam("password")String password) {
		if(uService.checkEmail(email)) {
			System.out.println("Inside method");
			boolean val=uService.validate(email, password);
			//if user is valid
			if(val==true) {
				if(uService.getUserRole(email).equals("trainer")) {
					return "trainerHome";
				}
				else {
					return "studentHome";
				}
			}
			else {
				System.out.println("incorrect credentilas, try again!");
				return "login";
			}
		}
		else {
			return "login";
		}

	}
	@PostMapping("/addcomment")
	public String Comments(@RequestParam("comment") String comment 
			                ,Model model)
	{
		Comments c=new Comments();
		c.setComment(comment);
		cservice.addComment(c);
		List<Comments> commentsList=cservice.commentList();
		model.addAttribute("comments",commentsList);
				
		return "demoLesson";
	}
}
