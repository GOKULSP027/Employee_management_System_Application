package com.spring.EMS_Application.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.EMS_Application.dto.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	Optional<Employee> findById (long id);
}
