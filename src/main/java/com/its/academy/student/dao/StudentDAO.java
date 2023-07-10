package com.its.academy.student.dao;

import java.util.List;

import com.its.academy.student.entity.Student;

public interface StudentDAO {

	Student saveOrUpdate(Student student);
	
	Student get(int id);

	void delete(Student student);
	
	List<Student> getAll();
}
