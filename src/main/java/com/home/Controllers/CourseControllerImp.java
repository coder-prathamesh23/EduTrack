package com.home.Controllers;

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
import com.home.Entities.Course;
import com.home.Services.CourseServiceImp;

@RestController
@RequestMapping("/api/courses/")
public class CourseControllerImp implements CourseControllerInterface {

	@Autowired
	private CourseServiceImp service;

	@Override
	@GetMapping("/getAllCourses")
	public List<Course> getAllCourses() {
		return service.getAllCourses();
	}

	@Override
	@GetMapping("/getSpecificCourseById/{id}")
	public List<Course> getSpecificCourseById(@PathVariable Long id) {
		return service.getSpecificCourseById(id);
	}

	@Override
	@PostMapping("/createNewCourse")
	public String createNewCourse(@RequestBody Course c) {
		return service.createNewCourse(c);
	}

	@Override
	@PutMapping("/updateExistingCourse/{id}")
	public String updateExistingCourse(@RequestBody Course c,@PathVariable Long id) {
		return service.updateExistingCourse(c, id);
	}

	@Override
	@DeleteMapping("/deleteCourse/{id}")
	public String deleteExistingCourse(@PathVariable Long id) {
		return service.deleteExistingCourse(id);
	}
	
	
}
