package com.example.demo.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Service.StudentService;
import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class StudentController {
	@Autowired
	StudentService service;

	@PostMapping("/goToLesson") 
	public String myLesson(@RequestParam("lessonId") long lessonId,Model model) {
		Lesson lesson=service.getLesson(lessonId);
		model.addAttribute("lesson",lesson);
		System.out.println(lesson);
		return "myLesson";
	}
    @PostMapping("/getCourseOnly")
    public String getLessonOnly(@RequestParam("courseId") long cousreId,Model model) {
    	List<Lesson> lessons=service.fetchLessonBycourseId(cousreId);
    	model.addAttribute("Lessons", lessons);
    	return "/demoLesson";
    }
    
    @GetMapping("/purchase")
    public String purchaseCourse(Model model)
    {
    	List<Course> courseList=service.CourseList();
    	System.out.println(courseList);
    	model.addAttribute("courseList",courseList);

    	return "purchase";
    	
    }
    
    @PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam("amount") int amount) {
		Order order=null;
		try {
			RazorpayClient razorpay=new  RazorpayClient("rzp_test_EoNPOLlYPh8oY0"
					+ "", "flNWRtWHWNgQZWiWRo96ln74");

			try {
				JSONObject orderRequest = new JSONObject();
				orderRequest.put("amount", amount*100); // amount in the smallest currency unit
				orderRequest.put("currency", "INR");
				orderRequest.put("receipt", "order_rcptid_11");

				order = razorpay.orders.create(orderRequest);
				System.out.println(order);
			} catch (RazorpayException e) {
				// Handle Exception
				System.out.println(e.getMessage());
			}
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return order.toString();
		}
	}
}
