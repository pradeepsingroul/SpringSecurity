package com.Security.Services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Security.Exceptions.EmployeeExceptions;
import com.Security.Models.Employee;
import com.Security.Repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo emplRepo;
	
	@Override
	public List<Employee> getAllEmployees() throws EmployeeExceptions {
		List<Employee> employees = emplRepo.findAll();
		if(employees.isEmpty()) {
			throw new EmployeeExceptions("Employees does not exist...");
		}else {
			return employees;
		}
	}

	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeExceptions {
		Employee opt = emplRepo.findByEmail(employee.getEmail());
		if(opt==null) {
			emplRepo.save(employee);
			return employee;
		}else {
			throw new EmployeeExceptions("Employee already register....");
		}
	}

}
