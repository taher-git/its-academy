package com.its.academy.student.service;

import java.util.List;

import com.its.academy.student.entity.Student;

public interface StudentService {
	
	Student saveOrUpdate(Student student);
	
	Student get(int id);

	void delete(Student student);
	
	List<Student> getAll();

}
