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

import com.home.Entities.Department;
import com.home.Services.DepartmentServiceImp;

@RestController
@RequestMapping("/api/departments")
public class DepartmentControllerImp implements DepartmentControllerInterface {

	@Autowired
	DepartmentServiceImp service;

	@Override
	@GetMapping("/getAllDepartments")
	public List<Department> getAllDepartments() {
		return service.getAllDepartments();
	}

	@Override
	@GetMapping("/getSpecificDepartmentById/{id}")
	public List<Department> getSpecificDepartmentById(@PathVariable Long id) {
		return service.getSpecificDepartmentById(id);
	}

	@Override
	@PostMapping("/createNewDepartment")
	public String createNewDepartment(@RequestBody Department d) {
		return service.createNewDepartment(d);
	}

	@Override
	@PutMapping("/updateExistingDepartment/{id}")
	public String updateExistingDepartment(@RequestBody Department d,@PathVariable Long id) {
		return service.updateExistingDepartment(d, id);
	}

	@Override
	@DeleteMapping("/deleteDepartment/{id}")
	public String deleteDepartmentById(@PathVariable Long id) {
		return service.deleteDepartmentById(id);
	}
	
}
