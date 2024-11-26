package com.home.common;

import java.util.List;

import com.home.Entities.Subject;

public interface SubjectBaseInterface {

	List<Subject> getAllSubjects();
	List<Subject> getSpecificSubjectById(Long id);
	String createNewSubject(Subject s);
	String updateExistingSubject(Subject s, Long id);
	String deleteSubjectById(Long id);
}
