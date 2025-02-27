package com.spring.EMS_Application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.EMS_Application.dto.Employee;
import com.spring.EMS_Application.response.ResponseStructure;
import com.spring.EMS_Application.dao.EmployeeDao;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeDao employeedao;
	public ResponseStructure<?> registerEmployee(Employee employee) 
	{
		Employee emp = employeedao.registerEmp(employee);
		ResponseStructure<Employee> structure = new ResponseStructure();
		structure.setData(emp);
		structure.setDatetime(LocalDateTime.now());
		structure.setStatusCode(201);
		structure.setMessage("Employee Registration success");
		return structure;
	}
	public ResponseStructure<List<Employee>> getAllEmployee() 
	{
		List<Employee> allEmployee = employeedao.getAllEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure();
		structure.setData(allEmployee);
		structure.setDatetime(LocalDateTime.now());
		structure.setStatusCode(302);
		structure.setMessage("All Employee data fetched successfully");
		return structure;
	}
	public Employee getEmployeeById(int id) 
	{
		Employee employee = employeedao.getById(id);
		return employee;
	}
	public Employee updateEmp(Employee employee) 
	{
		Employee employee2 = employeedao.updateEmp(employee);
		return employee2;
	}
	public String deleteEmp(int id) 
	{
		String string = employeedao.deleteEmp(id);
		return string;
	}
}
