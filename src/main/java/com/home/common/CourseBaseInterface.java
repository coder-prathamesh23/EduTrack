package com.home.common;

import java.util.List;

import com.home.Entities.Course;

public interface CourseBaseInterface {

	List<Course> getAllCourses();
	List<Course> getSpecificCourseById(Long id);
	String createNewCourse(Course c);
	String updateExistingCourse(Course c, Long id);
	String deleteExistingCourse(Long id);
}
