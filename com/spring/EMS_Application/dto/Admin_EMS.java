package com.spring.EMS_Application.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity(name = "Admin")
public class Admin_EMS 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminID;
	@Column(name="adminName")
	private String adminName;
	@Column(name="adminPassword")
	private String adminPassword;

}
