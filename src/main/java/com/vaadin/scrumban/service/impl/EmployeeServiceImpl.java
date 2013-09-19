package com.vaadin.scrumban.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vaadin.scrumban.dao.EmployeeDao;
import com.vaadin.scrumban.model.Employee;
import com.vaadin.scrumban.service.EmployeeService;

@Service( "employeeService" )
public class EmployeeServiceImpl implements EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;

	@Transactional
	public List<Employee> getAllEmployees()
	{
		// TODO Auto-generated method stub
		return employeeDao.getAllEmployees();
	}
	@Transactional
	public int insertEmployee(Employee emp) {
		return employeeDao.insertEmployee(emp);
		
	}
	@Transactional
	public void deleteEmployee(int EmpID) {
		employeeDao.deleteEmployee(EmpID);
		
	}
	public int updateEmployee(int EmpID) {
		Employee emp = employeeDao.updateEmployee(EmpID);
		return emp.getId();
	}
}
