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

import com.home.Entities.ClassSchedule;
import com.home.Services.ClassScheduleServiceImp;

@RestController
@RequestMapping("/api/classSchedules")
public class ClassScheduleControllerImp implements ClassScheduleControllerInterface {

	@Autowired
	private ClassScheduleServiceImp service;

	@Override
	@GetMapping("/getAllClassSchedules")
	public List<ClassSchedule> getAllClassSchedules() {

		return service.getAllClassSchedules();
	}

	@Override
	@GetMapping("/getClassScheduleById/{id}")
	public List<ClassSchedule> getClassScheduleById(@PathVariable Long id) {
		return service.getClassScheduleById(id);
	}

	@Override
	@PostMapping("/createNewClassSchedule")
	public String createNewClassSchedule(@RequestBody ClassSchedule cs) {
		
		return service.createNewClassSchedule(cs);
	}

	@Override
	@PutMapping("/updateExistingClassScheduleById/{id}")
	public String updateExistingClassSchedule(@RequestBody ClassSchedule cs,@PathVariable Long id) {
		
		return service.updateExistingClassSchedule(cs, id);
	}

	@Override
	@DeleteMapping("/deleteClassSchedule/{id}")
	public String deleteClassScheduleById(@PathVariable Long id) {
		return service.deleteClassScheduleById(id);
	}
	
	
	
}
