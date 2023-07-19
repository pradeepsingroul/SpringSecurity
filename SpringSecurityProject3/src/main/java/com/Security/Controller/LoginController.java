package com.Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.Models.Employee;
import com.Security.Repository.EmployeeRepo;

@RestController
public class LoginController {

	@Autowired
	private EmployeeRepo emplRepo;
	
	@GetMapping("/signin")
	public ResponseEntity<Employee> loginController(Authentication auth) throws Exception{
		Employee empl = emplRepo.findByEmail(auth.getName());
		if(empl != null) {
			return new ResponseEntity<Employee>(empl, HttpStatus.ACCEPTED);
		}else {
			throw new Exception("Employee does not exist with the email...");
		}
	}
	
	
}
