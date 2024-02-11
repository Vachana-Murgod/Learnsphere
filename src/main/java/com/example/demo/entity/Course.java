 	package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Course {
	@Id
    long courseId;
    String courseName;
    long coursePrice;
    @OneToMany
    List<Lesson> lessons;
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(long courseId, String courseName, long coursePrice, List<Lesson> lessons) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.lessons = lessons;
	}
	public long getCourseId() {
		return courseId;
	}
	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public long getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(long coursePrice) {
		this.coursePrice = coursePrice;
	}
	public List<Lesson> getLessons() {
		return lessons;
	}
	public void setLessons(List<Lesson> lessons) {
		this.lessons = lessons;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", lessons=" + lessons + "]";
	}
	
	
	
    
}
