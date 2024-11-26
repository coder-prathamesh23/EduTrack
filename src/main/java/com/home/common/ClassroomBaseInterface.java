package com.home.common;

import java.util.List;

import com.home.Entities.Classroom;

public interface ClassroomBaseInterface {
	String rootMessage();

	List<Classroom> getAllClassrooms();

	List<Classroom> getSpecificClassroomById(Long id);

	String createNewClassroom(Classroom c);

	String updateExistingClassroom(Classroom c, Long id);

	String deleteClassroom(Long id);
}
