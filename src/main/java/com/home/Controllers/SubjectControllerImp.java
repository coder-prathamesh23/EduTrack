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

import com.home.Entities.Subject;
import com.home.Services.SubjectServiceImp;

@RestController
@RequestMapping("/api/subjects")
public class SubjectControllerImp implements SubjectControllerInterface {

	@Autowired
	SubjectServiceImp service;

	@Override
	@GetMapping("/getAllSubjects")
	public List<Subject> getAllSubjects() {
		return service.getAllSubjects();
	}

	@Override
	@GetMapping("/getSpecificSubjectById/{id}")
	public List<Subject> getSpecificSubjectById(@PathVariable Long id) {
		return service.getSpecificSubjectById(id);
	}

	@Override
	@PostMapping("/createNewSubject")
	public String createNewSubject(@RequestBody Subject s) {
		return service.createNewSubject(s);
	}

	@Override
	@PutMapping("/updateExistingSubject/{id}")
	public String updateExistingSubject(@RequestBody Subject s,@PathVariable Long id) {
		return service.updateExistingSubject(s, id);
	}

	@Override
	@DeleteMapping("/deleteSubjectById/{id}")
	public String deleteSubjectById(@PathVariable Long id) {
		return service.deleteSubjectById(id); 
	}
	
	
	
}
