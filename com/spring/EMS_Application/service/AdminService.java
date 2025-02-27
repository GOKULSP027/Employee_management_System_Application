package com.spring.EMS_Application.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.EMS_Application.controller.EmployeeController;
import com.spring.EMS_Application.dao.AdminDao;
import com.spring.EMS_Application.dto.Admin_EMS;
import com.spring.EMS_Application.response.ResponseStructure;

@Service
public class AdminService 
{
	@Autowired
	AdminDao admindao;
	@Autowired
	EmployeeController employeecontroller;
	public ResponseStructure<Admin_EMS>adminLogin(String adminname,String password)
	{
		ResponseStructure<Admin_EMS> response = new ResponseStructure<>();
		Admin_EMS loginRequest=admindao.getDetailbyAdminName(adminname);
		if (loginRequest == null) {

		}
		if (!loginRequest.getAdminPassword().equals(password)) {

		}
		response.setData(loginRequest);
		response.setMessage("details fetched!!");
		response.setDatetime(LocalDateTime.now());
		response.setStatusCode(200);
		return response;
	}
}
