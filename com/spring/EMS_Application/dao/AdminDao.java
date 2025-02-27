package com.spring.EMS_Application.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.EMS_Application.dto.Admin_EMS;
import com.spring.EMS_Application.repository.AdminRepository;
@Repository
public class AdminDao {
	@Autowired
	AdminRepository adminrepository;
	public List <Admin_EMS> getAllAdmins(){
		return adminrepository.findAll();
	}
	public Admin_EMS getDetailbyAdminName(String adminname) {
		return adminrepository.findByAdminName(adminname).orElse(null);
	}
}
