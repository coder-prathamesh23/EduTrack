package com.home.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.Dao.SubjectDaoImp;
import com.home.Entities.Subject;

@Service
public class SubjectServiceImp implements SubjectServiceInterface{

	@Autowired
	SubjectDaoImp dao;

	@Override
	public List<Subject> getAllSubjects() {
		return dao.getAllSubjects();
	}

	@Override
	public List<Subject> getSpecificSubjectById(Long id) {
		return dao.getSpecificSubjectById(id);
	}

	@Override
	public String createNewSubject(Subject s) {
		return dao.createNewSubject(s);
	}

	@Override
	public String updateExistingSubject(Subject s, Long id) {
		return dao.updateExistingSubject(s, id);
	}

	@Override
	public String deleteSubjectById(Long id) {
		return dao.deleteSubjectById(id);
	}
	
}
