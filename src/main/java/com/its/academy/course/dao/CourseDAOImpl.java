package com.its.academy.course.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.its.academy.course.entity.Course;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CourseDAOImpl implements CourseDAO{

	private EntityManager entityManager;
	
	@Autowired
	public CourseDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public Course saveOrUpdate(Course course) {
		return entityManager.merge(course);
	}


	@Override
	public List<Course> getAll() {
		TypedQuery<Course> theQuery = entityManager.createQuery("from Course", Course.class);
		List<Course> courses = theQuery.getResultList();
		return courses;
	}


	@Override
	public Course get(int id) {
		return entityManager.find(Course.class, id);
	}


	@Override
	public void delete(Course course) {
		entityManager.remove(course);
		
	}

}
