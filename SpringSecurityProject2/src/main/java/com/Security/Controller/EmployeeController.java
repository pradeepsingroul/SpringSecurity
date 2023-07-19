package com.Security.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.Models.Employee;
import com.Security.Services.EmployeeServices;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServices emplService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("")
	public ResponseEntity<Employee> registerEmployeeHanlder(@RequestBody Employee employee){
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Employee empl = emplService.registerEmployee(employee);
		return new ResponseEntity<Employee>(empl,HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Employee>> getallEmployees(){
		List<Employee> empl = emplService.getAllStudents();
		return new ResponseEntity<List<Employee>>(empl,HttpStatus.CREATED);
	}
	
}
