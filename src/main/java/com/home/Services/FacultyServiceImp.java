package com.home.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Dao.FacultyDaoImp;
import com.home.Entities.Faculty;

@Service
public class FacultyServiceImp implements FacultyServiceInterface {

	@Autowired
	FacultyDaoImp dao;

	@Override
	public List<Faculty> getAllFaculty() {
		return dao.getAllFaculty();
	}

	@Override
	public List<Faculty> getSpecificFacultyById(Long id) {
		return dao.getSpecificFacultyById(id);
	}

	@Override
	public String createNewFaculty(Faculty f) {
		return dao.createNewFaculty(f);
	}

	@Override
	public String updateExistingFaculty(Faculty f, Long id) {
		return dao.updateExistingFaculty(f, id);
	}

	@Override
	public String deleteFacultyById(Long id) {
		return dao.deleteFacultyById(id);
	}
	
	
	
}
