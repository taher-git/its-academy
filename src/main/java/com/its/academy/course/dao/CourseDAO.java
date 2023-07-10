package com.its.academy.course.dao;

import java.util.List;

import com.its.academy.course.entity.Course;

public interface CourseDAO {

	Course saveOrUpdate(Course course);
	
	Course get(int id);

	void delete(Course course);
	
	List<Course> getAll();
}
