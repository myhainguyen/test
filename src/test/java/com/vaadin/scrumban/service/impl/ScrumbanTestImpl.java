package com.vaadin.scrumban.service.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vaadin.scrumban.dao.AccountDao;
import com.vaadin.scrumban.dao.EmployeeDao;
import com.vaadin.scrumban.model.Account;
import com.vaadin.scrumban.model.Employee;

public class ScrumbanTestImpl extends ScrumbanTest {
	@Autowired
	EmployeeDao employeeDao ;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Test( groups = SERVICES_INTEGRATION_TEST_GROUP, enabled = true, priority = 102 )
	public void testLoadEmployee(){	
		List<Employee> lstEmp = employeeDao.getAllEmployees();		
		System.out.println("list size :"+lstEmp.size());
		Assert.assertEquals( 0, lstEmp.size());
		Employee e = new Employee();
		e.setFirstname("nguyen1");
		e.setLastname("test1");
		e.setAge("30");
		int i = employeeDao.insertEmployee(e);
		System.out.println("----------:"+i);
		lstEmp = employeeDao.getAllEmployees();
		System.out.println("list size :"+lstEmp.size());
		Assert.assertTrue(lstEmp.size() >= 1);
		
	}
	@Test( groups = SERVICES_INTEGRATION_TEST_GROUP, enabled = true, priority = 101 )
	public void testLoadAccount(){	
		List<Account> lst = accountDao.getAllAccouts();	
		System.out.println("list size :"+lst.size());
		Assert.assertEquals( 0, lst.size());
		Account e = new Account();
		e.setCity("city1");
		e.setCountry("country1");
		e.setMail("mail");
		e.setPhone("phone");
		e.setPostalCode("123");
		e.setStreet("street");
		e.setUserName("abc123");
		int i = accountDao.insertAccount(e);
		System.out.println("----------:"+i);
		lst = accountDao.getAllAccouts();	
		System.out.println("list size :"+lst.size());
//		Assert.assertTrue(lst.size() > 0);
		
	}
	
	@Test( groups = SERVICES_INTEGRATION_TEST_GROUP, enabled = true, priority = 103 )
	public void testInsertEmployee(){
		Employee e = new Employee();
		e.setFirstname("nguyen");
		e.setLastname("test");
		e.setAge("30");
		employeeDao.insertEmployee(e);
		Assert.assertNotEquals( e.getId(), 0 );
		
	}
	
//	@Test( groups = SERVICES_INTEGRATION_TEST_GROUP, enabled = true, priority = 104 )
//	public void testDeleteEmployee(){
//		List<Employee> lstEmp = employeeDao.getAllEmployees();		
//		Assert.assertTrue(lstEmp.size() > 0);		
//		Employee emp = lstEmp.get(lstEmp.size()-1);
//		employeeDao.deleteEmployee(emp.getId());
//		emp = employeeDao.updateEmployee(emp.getId());
//		Assert.assertNull(emp);
//	}
	
}
	