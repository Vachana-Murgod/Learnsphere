package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Service.TrainerService;
import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;

@Controller
public class TrainerController {
	@Autowired
	TrainerService tservice;

	@PostMapping("/createCourse")
	public String addCourse(@RequestParam("courseId") long courseId,
			@RequestParam("courseName") String courseName,
			@RequestParam("coursePrice") long coursePrice) {
		Course c=new Course();
		c.setCourseId(courseId);
		c.setCourseName(courseName);
		c.setCoursePrice(coursePrice);
		tservice.addCourse(c);
		return "redirect:/trainerHome";
	}
	@PostMapping("/addlesson")
	public String lesson(@RequestParam("courseId")long courseId,
			@RequestParam("lessonId")long lessonId,
			@RequestParam("lessonName")String lessonName,
			@RequestParam("topics")String topics,

			@RequestParam("link")String link) {
		Course course=tservice.getCourse(courseId);
		
		Lesson lesson=new Lesson(lessonId,lessonName,topics,link,course);
		course.getLessons().add(lesson);
		tservice.addLesson(lesson);
		return "redirect:/trainerHome";

	}
	@GetMapping("/showCourse")
	public String showCourse(Model model)
	{
		List<Course> courseList=tservice.courseList();
		model.addAttribute("courseList",courseList);

		System.out.println(courseList);
		return "Course";
	}

}
