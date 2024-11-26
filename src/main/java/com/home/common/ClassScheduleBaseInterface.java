package com.home.common;

import java.util.List;

import com.home.Entities.ClassSchedule;

public interface ClassScheduleBaseInterface {
	
	List<ClassSchedule> getAllClassSchedules();
	List<ClassSchedule> getClassScheduleById(Long id);
	String createNewClassSchedule(ClassSchedule cs);
	String updateExistingClassSchedule(ClassSchedule cs, Long id);
	String deleteClassScheduleById(Long id);
}
