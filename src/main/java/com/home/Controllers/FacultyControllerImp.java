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

import com.home.Entities.Faculty;
import com.home.Services.FacultyServiceImp;

@RestController
@RequestMapping("api/faculties")
public class FacultyControllerImp implements FacultyControllerInterface {

	@Autowired
	FacultyServiceImp service;
	
	@Override
	@GetMapping("/getAllFaculties")
	public List<Faculty> getAllFaculty() {
		return service.getAllFaculty();
	}

	@Override
	@GetMapping("/getSpecificFaculty/{id}")
	public List<Faculty> getSpecificFacultyById(@PathVariable Long id) {
		return service.getSpecificFacultyById(id);
	}

	@Override
	@PostMapping("/createNewFaculty")
	public String createNewFaculty(@RequestBody Faculty f) {
		return service.createNewFaculty(f);
	}

	@Override
	@PutMapping("/updateExistingFaculty/{id}")
	public String updateExistingFaculty(@RequestBody Faculty f,@PathVariable Long id) {
		return service.updateExistingFaculty(f, id);
	}

	@Override
	@DeleteMapping("/deleteFacultyById/{id}")
	public String deleteFacultyById(@PathVariable Long id) {
		return service.deleteFacultyById(id);
	}

	
	
}