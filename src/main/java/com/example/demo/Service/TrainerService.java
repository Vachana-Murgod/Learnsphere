package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;

public interface TrainerService {
	public String addCourse(Course course);


	public String addLesson(Lesson lesson);

	public Course getCourse(long courseId);

	public List<Course> courseList();
}
