package com.its.academy.course.service;

import java.util.List;

import com.its.academy.course.entity.Course;

public interface CourseService {
	
	Course saveOrUpdate(Course course);
	
	Course get(int id);

	void delete(Course course);
	
	List<Course> getAll();

}
