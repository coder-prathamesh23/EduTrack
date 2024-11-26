package com.home.common;
import java.util.List;

import com.home.Entities.Department;
public interface DepartmentBaseInterface {
	
	List<Department> getAllDepartments();
	List<Department> getSpecificDepartmentById(Long id);
	String createNewDepartment(Department d);
	String updateExistingDepartment(Department d,Long id);
	String deleteDepartmentById(Long id);
}
