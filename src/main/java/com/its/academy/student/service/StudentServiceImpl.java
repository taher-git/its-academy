package com.its.academy.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.academy.student.dao.StudentDAO;
import com.its.academy.student.entity.Student;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService{

	private StudentDAO studentDAO;
	
	@Autowired
	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}


	@Override
	@Transactional
	public Student saveOrUpdate(Student student) {
		return studentDAO.saveOrUpdate(student);	
	}


	@Override
	@Transactional
	public List<Student> getAll() {
		return studentDAO.getAll();
	}


	@Override
	@Transactional
	public Student get(int id) {
		return studentDAO.get(id);
	}


	@Override
	@Transactional
	public void delete(Student student) {
		studentDAO.delete(student);
	}

}
