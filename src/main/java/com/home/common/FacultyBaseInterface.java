package com.home.common;
import java.util.List;

import  com.home.Entities.Faculty;
public interface FacultyBaseInterface {
	List<Faculty> getAllFaculty();
	List<Faculty> getSpecificFacultyById(Long id);
	String createNewFaculty(Faculty f);
	String updateExistingFaculty(Faculty f, Long id);
	String deleteFacultyById(Long id);
}
