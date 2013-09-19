package com.vaadin.scrumban.service;

import java.util.List;

import com.vaadin.scrumban.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();
	public int insertEmployee(Employee emp);
	public void deleteEmployee(int EmpID);
	public int updateEmployee(int EmpID);
}
