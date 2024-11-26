package com.home.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.Entities.Subject;

@Repository
public class SubjectDaoImp implements SubjectDaoInterface {

	@Autowired
	SessionFactory factory;

	@Override
	public List<Subject> getAllSubjects() {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Subject.class);
		List<Subject> lst = c.list();
		return lst;
	}

	@Override
	public List<Subject> getSpecificSubjectById(Long id) {
		Session session = factory.openSession();
		Subject s = session.get(Subject.class, id);
		List<Subject> lst = new ArrayList<Subject>();
		lst.add(s);
		return lst;

	}

	@Override
	public String createNewSubject(Subject s) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Subject s1  = session.get(Subject.class, s.getId());
		if(s1 == null) {
			session.save(s);
			tx.commit();
			return "Subject Added Successfully";
		}
		else {
			return "Another Subject with the Same Id is Already present.\nPlease Choose a different One";
		}
	}

	@Override
	public String updateExistingSubject(Subject s, Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Subject s1 = session.get(Subject.class, id);
		if(s1 != null) {
			s1.setName(s.getName());
			s1.setCourseId(s.getCourseId());
			s1.setDescription(s.getDescription());
			s1.setDepartmentId(s.getDepartmentId());
			session.update(s1);
			tx.commit();
			return "Subject Updated Successfully";
		}
		else {
			return "No Subject With The Provided Id Was Found.\nPlease Choose a Different One";
		}
	}

	@Override
	public String deleteSubjectById(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Subject s = session.get(Subject.class, id);
		if(s != null) {
			session.delete(s);
			tx.commit();
			return "Subject Deleted Successfully";
		}
		else {
			return "No Subject With The Provided Id Exists.\nPlease Provide a Different One.";
		}
	}

}
