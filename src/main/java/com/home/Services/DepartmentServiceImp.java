package com.home.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Dao.DepartmentDaoImp;
import com.home.Entities.Department;

@Service
public class DepartmentServiceImp implements DepartmentServiceInterface{

	@Autowired
	DepartmentDaoImp dao;

	@Override
	public List<Department> getAllDepartments() {
		return dao.getAllDepartments();
	}

	@Override
	public List<Department> getSpecificDepartmentById(Long id) {
		return dao.getSpecificDepartmentById(id);
	}

	@Override
	public String createNewDepartment(Department d) {
		return dao.createNewDepartment(d);
	}

	@Override
	public String updateExistingDepartment(Department d, Long id) {
		return dao.updateExistingDepartment(d, id);
	}

	@Override
	public String deleteDepartmentById(Long id) {
		return dao.deleteDepartmentById(id);
	}
	
}
