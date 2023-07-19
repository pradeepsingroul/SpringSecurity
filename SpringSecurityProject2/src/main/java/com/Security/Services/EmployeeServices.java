package com.Security.Services;

import java.util.List;

import com.Security.Exceptions.EmployeeExceptions;
import com.Security.Models.Employee;

public interface EmployeeServices {
	
	Employee registerEmployee(Employee employee) throws EmployeeExceptions;

	List<Employee> getAllStudents() throws EmployeeExceptions;

}
