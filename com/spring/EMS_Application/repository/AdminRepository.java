package com.spring.EMS_Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.spring.EMS_Application.dto.Admin_EMS;
@Repository
public interface AdminRepository extends JpaRepository<Admin_EMS, Long> 
{
	Optional<Admin_EMS> findByAdminName(String adminName);
}
