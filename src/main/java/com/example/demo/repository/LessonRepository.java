package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Long>{

	List<Lesson> findLessonsByCourseCourseId(long courseId);
}
