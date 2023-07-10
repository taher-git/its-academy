package com.its.academy.student.entity;

import java.util.ArrayList;
import java.util.List;

import com.its.academy.course.entity.Course;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "fullname")
	private String fullName;

	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "address")
	private String address;
	
	@ManyToMany
	@JoinTable(
			name = "course_student",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id")
			)
	List<Course> courses;
	public Student() {
		super();
	}

	public Student(String fullName, String email, String telephone, String address) {
		super();
		this.fullName = fullName;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public void addCourse(Course course) {
		if(courses == null) {
			courses = new ArrayList<Course>();
		}
		courses.add(course);
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", email=" + email + ", telephone=" + telephone
				+ ", address=" + address + "]";
	}

	
}
