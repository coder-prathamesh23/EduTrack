package com.home.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.Entities.Course;

@Repository
public class CourseDaoImp implements CourseDaoInterface {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<Course> getAllCourses() {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Course.class);
		List<Course> lst = c.list();
		return lst;
	}

	@Override
	public List<Course> getSpecificCourseById(Long id) {
		Session session = factory.openSession();
		Course c = session.get(Course.class, id);
		List<Course> lst = new ArrayList<Course>();
		lst.add(c);
		return lst;
	}

	@Override
	public String createNewCourse(Course c) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course c1 = session.get(Course.class, c.getId());
		if (c1 == null) {
			session.save(c);
			tx.commit();
			return "Course Created Successfully";
		} else {
			return "Another Course with same Id already Exists.\nPlease Choose a Different One";
		}
	}

	@Override
	public String updateExistingCourse(Course c, Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course c1 = session.get(Course.class, id);
		if (c1 == null) {
			return "No Such Course Found";
		}
		c1.setName(c.getName());
		session.update(c1);
		tx.commit();
		return "Course Updated Successfully";

	}

	@Override
	public String deleteExistingCourse(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Course c = session.get(Course.class, id);
		if(c == null) {
			return "No Such Course Found";
		}
		session.delete(c);
		tx.commit();
		return "Course Deleted Successfully";
	}
}
