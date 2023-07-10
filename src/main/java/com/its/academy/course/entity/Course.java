package com.its.academy.course.entity;

import java.util.ArrayList;
import java.util.List;

import com.its.academy.student.entity.Student;

import jakarta.persistence.*;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@ManyToMany
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name = "course_id"),
			inverseJoinColumns = @JoinColumn(name = "student_id")
			)
	private List<Student> students;
	public Course() {
		super();
	}

	public Course(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public void addStudent(Student student) {
		if(students == null) {
			students = new ArrayList<Student>();
		}
		students.add(student);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
}
