package com.home.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Dao.ClassroomDaoImp;
import com.home.Entities.Classroom;

@Service
public class ClassroomServiceImp implements ClassroomServiceInterface {

	@Autowired
	private ClassroomDaoImp dao;

	public String rootMessage() {
		return dao.rootMessage();
	}

	public List<Classroom> getAllClassrooms() {
		return dao.getAllClassrooms();
	}

	@Override
	public List<Classroom> getSpecificClassroomById(Long id) {
		return dao.getSpecificClassroomById(id);
	}

	@Override
	public String createNewClassroom(Classroom c) {
		return dao.createNewClassroom(c);
	}

	@Override
	public String updateExistingClassroom(Classroom c, Long id) {
		return dao.updateExistingClassroom(c, id);
	}

	@Override
	public String deleteClassroom(Long id) {
		return dao.deleteClassroom(id);
	}

}
