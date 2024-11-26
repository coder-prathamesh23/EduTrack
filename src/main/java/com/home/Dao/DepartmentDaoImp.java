package com.home.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.Entities.Department;

@Repository
public class DepartmentDaoImp implements DepartmentDaoInterface {

	@Autowired
	SessionFactory factory;

	@Override
	public List<Department> getAllDepartments() {
		Session session = factory.openSession();
		Criteria c = session.createCriteria(Department.class);
		List<Department> lst = c.list();
		return lst;
	}

	@Override
	public List<Department> getSpecificDepartmentById(Long id) {
		Session session = factory.openSession();
		Department d1 = session.get(Department.class, id);
		List<Department> lst = new ArrayList<Department>();
		lst.add(d1);
		return lst;
	}

	@Override
	public String createNewDepartment(Department d) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Department d1 = session.get(Department.class, d.getId());
		if(d1 == null) {
			session.save(d);
			tx.commit();
			return "Department Created Successully";
		}
		else
		{
			return "A Department With The Same Id is Already Present.\nPleaase try a different one";
		}
	}

	@Override
	public String updateExistingDepartment(Department d, Long id) {
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Department d1 = session.get(Department.class, id);
		if(d1 != null) {
			d1.setName(d.getName());
			session.update(d1);
			tx.commit();
			return "Department Updated Successfully";
		}
		else {
			return "No Department With Provided Id Exists.";
		}
	}

	@Override
	public String deleteDepartmentById(Long id) {
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Department d = session.get(Department.class, id);
		if(d != null) {
			session.delete(d);
			tx.commit();
			return "Department Deleted Successfully";
		}
		else {
			return "No Department With The Provided Id Exists";
		}
	}
	
}
