package com.example.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.LessonRepository;

@Service
public class StudentServiceImplementation implements StudentService{
	@Autowired
	LessonRepository lessonrepo;
	
	@Autowired
	CourseRepository courserepo;

	@Override
	public Lesson getLesson(long lessonId) {

		return lessonrepo.findById(lessonId).get();
	}

	@Override
	public List<Lesson> fetchLessonBycourseId(long courseId) {
		// TODO Auto-generated method stub
		return lessonrepo.findLessonsByCourseCourseId(courseId);
	}

	@Override
	public List<Course> CourseList() {
		// TODO Auto-generated method stub
		return courserepo.findAll();
	}

}
