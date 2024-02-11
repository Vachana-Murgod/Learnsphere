package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Course;
import com.example.demo.entity.Lesson;

public interface StudentService {
	Lesson getLesson(long lessonId);
	List<Lesson> fetchLessonBycourseId(long courseId);
	List<Course> CourseList();
}
