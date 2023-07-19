package com.Security.Controller;

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
import com.Security.Services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService emplService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@PostMapping("/register")
	public ResponseEntity<Employee> registerEmployeeHandler(@RequestBody Employee employee){
		employee.setPassword(passwordEncoder.encode(employee.getPassword()));
		Employee empl = emplService.registerEmployee(employee);
		return new ResponseEntity<Employee>(empl,HttpStatus.CREATED);
	}
	
	@GetMapping("/hello")
	public ResponseEntity<String> getHello(){
		String empl = "emplService.registerEmployee(employee)";
		return new ResponseEntity<String>(empl,HttpStatus.CREATED);
	}
	
	
}
