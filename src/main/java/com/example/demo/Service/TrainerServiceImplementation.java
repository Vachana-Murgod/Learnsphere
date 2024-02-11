package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LessonRepository;

@Service
public class TrainerServiceImplementation implements TrainerService{
	@Autowired
	CourseRepository crepo;

	@Autowired
	LessonRepository lrepo;

	public String addCourse(Course course) {
		crepo.save(course);
		return "Course added Successfully";
	}

	@Override
	public String addLesson(Lesson lesson) {
		lrepo.save(lesson);
		return "lesson added successfully!";
	}

	@Override
	public Course getCourse(long courseId) {

		return crepo.findById(courseId).get();
	}

	@Override
	public List<Course> courseList() {

		return crepo.findAll();
	}
	
}
