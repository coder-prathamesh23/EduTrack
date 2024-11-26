package com.home.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Dao.ClassScheduleDaoImp;
import com.home.Entities.ClassSchedule;

@Service
public class ClassScheduleServiceImp implements ClassScheduleServiceInterface {

	@Autowired
	private ClassScheduleDaoImp dao;

	@Override
	public List<ClassSchedule> getAllClassSchedules() {

		return dao.getAllClassSchedules();
	}

	@Override
	public List<ClassSchedule> getClassScheduleById(Long id) {
		return dao.getClassScheduleById(id);
	}

	@Override
	public String createNewClassSchedule(ClassSchedule cs) {
		
		return dao.createNewClassSchedule(cs);
	}

	@Override
	public String updateExistingClassSchedule(ClassSchedule cs, Long id) {
		
		return dao.updateExistingClassSchedule(cs, id);
	}

	@Override
	public String deleteClassScheduleById(Long id) {
		return dao.deleteClassScheduleById(id);
	}

}
