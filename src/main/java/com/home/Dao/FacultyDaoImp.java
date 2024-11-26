package com.home.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.home.Entities.Faculty;

@Repository
public class FacultyDaoImp implements FacultyDaoInterface {

	@Autowired
	SessionFactory factory;

	@Override
	public List<Faculty> getAllFaculty() {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Faculty.class);
		List<Faculty> lst = c.list();
		return lst;
	}

	@Override
	public List<Faculty> getSpecificFacultyById(Long id) {
		Session session = factory.openSession();
		Faculty f = session.get(Faculty.class, id);
		List<Faculty> lst = new ArrayList<Faculty>();
		lst.add(f);
		return lst;
	}

	@Override
	public String createNewFaculty(Faculty f) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Faculty f1 = session.get(Faculty.class, f.getId());
		if(f1 == null) {
			session.save(f);
			tx.commit();
			return "Faculty Created Successfully";
		}
		else {
			return "Another Id with The Same Id already Exists.\nPlease Use a Different One.";
		}
	}

	@Override
	public String updateExistingFaculty(Faculty f, Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Faculty f1 = session.get(Faculty.class, f.getId());
		if(f1 != null) {
			f1.setName(f.getName());
			f1.setEmail(f.getEmail());
			f1.setDepartmentId(f.getDepartmentId());
			session.update(f1);
			tx.commit();
			return "Faculty Details Updated Successfully";
		}
		else {
			return "No Faculty with the provided Id Exists.\nPlease Choose a Different one.";
		}
	}

	@Override
	public String deleteFacultyById(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Faculty f = session.get(Faculty.class, id);
		if(f != null) {
			session.delete(f);
			tx.commit();
			return "Faculty Deleted Successfully";
		}
		else {
			return "No Faculty with the provided Id Exists.\\nPlease Choose a Different one.";
		}
	}
	
	
}
