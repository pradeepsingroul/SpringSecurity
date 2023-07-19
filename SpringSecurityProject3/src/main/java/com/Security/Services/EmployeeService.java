package com.Security.Services;

import java.util.List;

import com.Security.Exceptions.EmployeeExceptions;
import com.Security.Models.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployees() throws EmployeeExceptions;
	
	Employee registerEmployee(Employee employee) throws EmployeeExceptions;

}
