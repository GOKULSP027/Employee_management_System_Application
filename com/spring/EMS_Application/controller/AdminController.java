package com.spring.EMS_Application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.EMS_Application.response.ResponseStructure;
import com.spring.EMS_Application.service.AdminService;
@RestController
public class AdminController {	
	@Autowired
	AdminService adminservice;
	@GetMapping("/adminlogin")
	ResponseEntity<?> adminlogin(@RequestParam String adminName,@RequestParam String adminPassword)
	{
		ResponseStructure<?> loginadmin=adminservice.adminLogin(adminName, adminPassword);
		return new ResponseEntity<>(loginadmin, HttpStatus.FOUND);
	}
}
