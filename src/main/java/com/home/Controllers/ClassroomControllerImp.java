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

import com.home.Entities.Classroom;
import com.home.Services.ClassroomServiceImp;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomControllerImp implements ClassroomControllerInterface {

	@Autowired
	private ClassroomServiceImp service;

	@GetMapping("/")
	@Override
	public String rootMessage() {
		return service.rootMessage();
	}

	@GetMapping("/getAllClassrooms")
	@Override
	public List<Classroom> getAllClassrooms() {
		return service.getAllClassrooms();
	}

	@GetMapping("/getSpecificClassroomById/{id}")
	@Override
	public List<Classroom> getSpecificClassroomById(@PathVariable Long id) {
		return service.getSpecificClassroomById(id);
	}

	@PostMapping("/createNewClassroom")
	@Override
	public String createNewClassroom(@RequestBody Classroom c) {

		return service.createNewClassroom(c);
	}

	@PutMapping("/updateClassroom/{id}")
	@Override
	public String updateExistingClassroom(@RequestBody Classroom c, @PathVariable Long id) {
		return service.updateExistingClassroom(c, id);
	}

	@DeleteMapping("/deleteClassroom/{id}")
	@Override
	public String deleteClassroom(@PathVariable Long id) {
		return service.deleteClassroom(id);
	}

}
