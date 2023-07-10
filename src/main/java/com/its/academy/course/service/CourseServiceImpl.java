package com.its.academy.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.academy.course.dao.CourseDAO;
import com.its.academy.course.entity.Course;

import jakarta.transaction.Transactional;

@Service
public class CourseServiceImpl implements CourseService{

	private CourseDAO courseDAO;
	
	@Autowired
	public CourseServiceImpl(CourseDAO courseDAO) {
		super();
		this.courseDAO = courseDAO;
	}


	@Override
	@Transactional
	public Course saveOrUpdate(Course course) {
		return courseDAO.saveOrUpdate(course);	
	}


	@Override
	@Transactional
	public List<Course> getAll() {
		return courseDAO.getAll();
	}


	@Override
	@Transactional
	public Course get(int id) {
		return courseDAO.get(id);
	}


	@Override
	@Transactional
	public void delete(Course course) {
		courseDAO.delete(course);
	}

}
