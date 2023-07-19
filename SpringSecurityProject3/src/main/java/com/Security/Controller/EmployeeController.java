package com.Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.Models.Employee;
import com.Security.Services.EmployeeService;

@RestController
@RequestMapping("/Employees")
public class EmployeeController {

	@Autowired
	private EmployeeService emplService;
	
	
	@PostMapping("")
	public ResponseEntity<Employee> registerEmployeeHandler(@RequestBody Employee employee){
		Employee empl = emplService.registerEmployee(employee);
		return new ResponseEntity<Employee>(empl,HttpStatus.CREATED);
	}
	
}
