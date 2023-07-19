package com.Security.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Security.Models.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
	
	Optional<Employee> findByEmail(String email);

}
