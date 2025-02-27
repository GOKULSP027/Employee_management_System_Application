package com.spring.EMS_Application.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.EMS_Application.dto.Employee;
import com.spring.EMS_Application.repository.EmployeeRepository;

@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;
	public Employee registerEmp(Employee employee) 
	{
		Employee dbEmp = employeeRepository.save(employee);
		return dbEmp;
	}

	public List<Employee> getAllEmployee() 
	{
		List<Employee> list = employeeRepository.findAll();
		return list;
	}
	public Employee getById(int Id)
	{
		Optional<Employee> optional = employeeRepository.findById(Id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	public Employee updateEmp(Employee employee) 
	{
		Optional<Employee> optional = employeeRepository.findById(employee.getId());
		if(optional.isPresent())
		{
			Employee employee2 = employeeRepository.save(employee);
			return employee2;
		}
		return null;
	}
	public String deleteEmp(int employeeId) 
	{
		Optional<Employee> optional = employeeRepository.findById(employeeId);
		if(optional.isPresent())
		{
			employeeRepository.delete(optional.get());
			return optional.get().getFname()+" "+optional.get().getLname()+" Employee data deleted successfully";
		}
		return null;
	}
}
