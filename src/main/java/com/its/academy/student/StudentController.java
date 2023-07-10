package com.its.academy.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.its.academy.course.entity.Course;
import com.its.academy.course.service.CourseService;
import com.its.academy.student.entity.Student;
import com.its.academy.student.service.StudentService;

@RestController
@RequestMapping("/its/api")
public class StudentController {
	
	StudentService studentService; 
	CourseService courseService; 
	private final String getAllCourse = "http://localhost:8080/its/api/course";
	@Autowired
	public StudentController(StudentService studentService,	CourseService courseService) {
		super();
		this.studentService = studentService;
		this.courseService = courseService;
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		student.setId(0);
		return studentService.saveOrUpdate(student);
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent() {
		return studentService.getAll();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") int id) {
		Student student = studentService.get(id);
		if(student == null) {
			throw new RuntimeException("Student not found - " + id);
		}
		return student;
	}
	
	@GetMapping("/student/courses")
	public Course[] getAllCourse() {
		RestTemplate template = new RestTemplate();
		Course[] courses = template.getForObject(this.getAllCourse, Course[].class);
		return courses;
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		return studentService.saveOrUpdate(student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		Student student = studentService.get(id);
		if(student == null) {
			throw new RuntimeException("Cousre not found - " + id);
		}
		studentService.delete(student);
		return "Student deleted - "+id;
	}
	
	@PostMapping("/allocate-courses/{studentId}")
	public Student allocateCourse(@PathVariable("studentId") int studentId, @RequestBody int[] courseIds) {
		Student student = studentService.get(studentId);
		if(student == null) {
			throw new RuntimeException("Student not found - " + studentId);
		}
		for (int id : courseIds) {			
			Course course = courseService.get(id);
			if(course != null) {
				student.addCourse(course);
			}
		}
		return studentService.saveOrUpdate(student);
	}
	
	@PostMapping("/get-students-for-selected-course")
	public List<Student> getStudents(@RequestBody int[] courseIds) {
		List<Student> students = new ArrayList<Student>();
		
		//need to implement 
		
		return students;
	}
}
