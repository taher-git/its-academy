package com.its.academy.course;

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

import com.its.academy.course.dao.CourseDAO;
import com.its.academy.course.entity.Course;
import com.its.academy.course.service.CourseService;

@RestController
@RequestMapping("/its/api")
public class CourseController {
	
	CourseService courseService; 
	
	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		course.setId(0);
		return courseService.saveOrUpdate(course);
	}
	
	@GetMapping("/course")
	public List<Course> getAllCourse() {
		return courseService.getAll();
	}
	
	@GetMapping("/course/{id}")
	public Course getCourse(@PathVariable("id") int id) {
		Course course = courseService.get(id);
		if(course == null) {
			throw new RuntimeException("Cousre not found - " + id);
		}
		return course;
	}
	
	@PutMapping("/course")
	public Course updateCourse(@RequestBody Course course) {
		return courseService.saveOrUpdate(course);
	}
	
	@DeleteMapping("/course/{id}")
	public String deleteCourse(@PathVariable("id") int id) {
		Course course = courseService.get(id);
		if(course == null) {
			throw new RuntimeException("Cousre not found - " + id);
		}
		courseService.delete(course);
		return "Course deleted - "+id;
	}
}
