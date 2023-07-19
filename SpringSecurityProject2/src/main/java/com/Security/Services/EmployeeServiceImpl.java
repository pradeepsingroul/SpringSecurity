package com.Security.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Security.Exceptions.EmployeeExceptions;
import com.Security.Models.Employee;
import com.Security.Repository.EmployeeRepo;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class EmployeeServiceImpl implements EmployeeServices{

	@Autowired
	private EmployeeRepo emplRepo;
	
	@Override
	public Employee registerEmployee(Employee employee) throws EmployeeExceptions {
		Employee empl = emplRepo.findByEmail(employee.getEmail());
		if(empl == null) {
			employee.getDepartments().getEmployees().add(employee);
			return emplRepo.save(employee);
		}else {
			throw new EmployeeExceptions("Employee is already exist eith the email :" + employee.getEmail()); 
		}
		
	}

	@Override
	public List<Employee> getAllStudents() throws EmployeeExceptions {
		List<Employee> employees = emplRepo.findAll();
		return employees;
	}

}
