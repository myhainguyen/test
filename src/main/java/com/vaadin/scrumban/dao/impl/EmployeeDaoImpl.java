package com.vaadin.scrumban.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vaadin.scrumban.dao.EmployeeDao;
import com.vaadin.scrumban.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	//private Session session;

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {
		return getSession().createQuery("from Employee").list();
	}

	public int insertEmployee(Employee emp) {
		this.getSession().save(emp);
		return emp.getId();
	}

	private Session getSession() {
		Session session;
			try {
				session = sessionFactory.getCurrentSession();

			} catch (Exception e) {
				session = sessionFactory.openSession();
			}
		
		return session;
	}

	public void deleteEmployee(int EmpID) {
		Employee employee = (Employee) getSession().load(Employee.class, EmpID);
		if (null != employee) {
			this.getSession().delete(employee);
		}

	}

	public Employee updateEmployee(int EmpID) {
		// TODO Auto-generated method stub
		return (Employee) getSession().load(Employee.class, EmpID);
	}

}
