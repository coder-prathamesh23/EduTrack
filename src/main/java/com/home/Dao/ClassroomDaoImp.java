package com.home.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.Entities.Classroom;

@Repository
public class ClassroomDaoImp implements ClassroomDaoInterface {

	@Autowired
	private SessionFactory factory;

	public String rootMessage() {
		return "Hello, Welcome to Attendance & Classroom Management System";
	}

	public List<Classroom> getAllClassrooms() {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Classroom.class);
		List<Classroom> clist = c.list();
		return clist;
	}

	@Override
	public List<Classroom> getSpecificClassroomById(Long id) {

		Session session = factory.openSession();
		Classroom c1 = session.get(Classroom.class, id);
		List<Classroom> lst = new ArrayList<Classroom>();
		lst.add(c1);
		return lst;

	}

	@Override
	public String createNewClassroom(Classroom c) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Classroom c1 = session.get(Classroom.class, c.getId());
		if (c1 == null) {
			session.save(c);
			tx.commit();
			return "Classroom Created Successfully";
		} else {
			return "Another Classroom with same Id already Exists.\n Please Choose a Different One";
		}
	}

	@Override
	public String updateExistingClassroom(Classroom c, Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Classroom c1 = session.get(Classroom.class, id);
		if (c1 == null) {
			return "No Such Classroom Found";
		}
		c1.setName(c.getName());
		session.update(c1);
		tx.commit();
		return "Classroom Updated Successfully";
	}

	@Override
	public String deleteClassroom(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Classroom c = session.get(Classroom.class, id);
		if (c != null) {
			session.delete(c);
			tx.commit();
			return "Classroom Deleted Successfully";
		} else {
			return "No Classroom With Given Id Was Found";
		}
	}

}
