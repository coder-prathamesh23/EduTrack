package com.home.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.Entities.ClassSchedule;
import com.home.Entities.Classroom;

@Repository
public class ClassScheduleDaoImp implements ClassScheduleDaoInterface {

	@Autowired
	private SessionFactory factory;

	@Override
	public List<ClassSchedule> getAllClassSchedules() {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(ClassSchedule.class);
		List<ClassSchedule> clist = c.list();
		return clist;
	}

	@Override
	public List<ClassSchedule> getClassScheduleById(Long id) {
		Session session = factory.openSession();
		ClassSchedule cs = session.get(ClassSchedule.class, id);
		List<ClassSchedule> lst = new ArrayList<ClassSchedule>();
		lst.add(cs);
		
		return lst;
	}

	@Override
	public String createNewClassSchedule(ClassSchedule cs) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		ClassSchedule c1 = session.get(ClassSchedule.class, cs.getId());
		if (c1 == null) {
			session.save(cs);
			tx.commit();
			return "Class Schedule Created Successfully";
		} else {
			return "Another Class Schedule with same Id already Exists.\nPlease Choose a Different One";
		}
	}

	@Override
	public String updateExistingClassSchedule(ClassSchedule cs, Long id) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		ClassSchedule c1 = session.get(ClassSchedule.class, id);
		if (c1 == null) {
			return "No Such Class Schedule Found";
		}
		c1.setDayOfWeek(cs.getDayOfWeek());
		c1.setStartTime(cs.getStartTime());
		c1.setEndTime(cs.getEndTime());
		c1.setClassroomId(cs.getClassroomId());
		c1.setSubjectId(cs.getSubjectId());
		session.update(c1);
		tx.commit();
		return "Class Schedule Updated Successfully";
	}

	@Override
	public String deleteClassScheduleById(Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		ClassSchedule c = session.get(ClassSchedule.class, id);
		if (c != null) {
			session.delete(c);
			tx.commit();
			return "Class Schedule Deleted Successfully";
		} else {
			return "No Class Schedule With Given Id Was Found";
		}
	}
 
}
