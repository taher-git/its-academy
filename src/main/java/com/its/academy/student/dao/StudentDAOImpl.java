package com.its.academy.student.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.its.academy.student.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

	private EntityManager entityManager;
	
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}


	@Override
	public Student saveOrUpdate(Student student) {
		return entityManager.merge(student);
	}


	@Override
	public List<Student> getAll() {
		TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
		List<Student> students = theQuery.getResultList();
		return students;
	}


	@Override
	public Student get(int id) {
		return entityManager.find(Student.class, id);
	}


	@Override
	public void delete(Student student) {
		entityManager.remove(student);
		
	}

}
