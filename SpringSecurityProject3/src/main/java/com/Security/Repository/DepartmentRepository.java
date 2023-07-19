package com.Security.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Security.Models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
