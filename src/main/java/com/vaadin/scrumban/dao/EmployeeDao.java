package com.vaadin.scrumban.dao;

import java.util.List;

import com.vaadin.scrumban.model.Employee;

public interface EmployeeDao {
	public List<Employee> getAllEmployees();
	public int insertEmployee(Employee emp);
	public void deleteEmployee(int EmpID);
	public Employee updateEmployee(int EmpID);
}
