package com.Security.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Security.Models.Employee;
import com.Security.Repository.EmployeeRepo;


@RestController
public class LoginController {
	
	@Autowired
    private EmployeeRepo studentRepository;
    
    @GetMapping("/employees/signin")
    public ResponseEntity<Employee> getloggenInStudentDetailsHandler(Authentication auth){
    	
    	System.out.println(auth);
    	
        Employee employee = studentRepository.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Student does not exist.."));
        
        return new ResponseEntity<Employee>(employee,HttpStatus.ACCEPTED);
     
    }

}
