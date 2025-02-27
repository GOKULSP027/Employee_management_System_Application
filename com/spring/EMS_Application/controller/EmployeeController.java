package com.spring.EMS_Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.EMS_Application.dto.Employee;
import com.spring.EMS_Application.response.ResponseStructure;
import com.spring.EMS_Application.service.EmployeeService;
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@PostMapping("/register")
	//url--> localhost:8080/register
	public ResponseEntity<?> registerEmp(@RequestBody Employee emp)
	{
		ResponseStructure<?> employee = employeeService.registerEmployee(emp);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
	}
	@GetMapping("/get")
	public ResponseEntity<?> getAllEmployee()
	{
		ResponseStructure<?> allemployee = employeeService.getAllEmployee();
		return new ResponseEntity<>(allemployee,HttpStatus.FOUND);
	}
	
	@GetMapping("/getEmpByid")
	//  localhost:8080/getEmpById?employeeId=2
	public Employee getEmployeeById(@RequestParam int id)
	{
		Employee employee = employeeService.getEmployeeById(id);
		return employee;
	}
	
	@PutMapping("/update")
	public String updateEmp(@RequestBody Employee employee)
	{
		Employee emp = employeeService.updateEmp(employee);
		return emp.getFname()+" "+emp.getLname()+" Your record updated";
	}
	
	@DeleteMapping("/delete")
	public String deleteEmp(@RequestParam int id)
	{
		String string = employeeService.deleteEmp(id);
		return string;
	}
}
