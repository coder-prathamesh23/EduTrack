package com.home.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Dao.CourseDaoImp;
import com.home.Entities.Course;

@Service
public class CourseServiceImp implements CourseServiceInterface{

	@Autowired
	private CourseDaoImp dao;

	@Override
	public List<Course> getAllCourses() {
		return dao.getAllCourses();
	}

	@Override
	public List<Course> getSpecificCourseById(Long id) {
		return dao.getSpecificCourseById(id);
	}

	@Override
	public String createNewCourse(Course c) {
		return dao.createNewCourse(c);
	}

	@Override
	public String updateExistingCourse(Course c, Long id) {
		return dao.updateExistingCourse(c, id);
	}

	@Override
	public String deleteExistingCourse(Long id) {
		return dao.deleteExistingCourse(id);
	}
	
	
}
