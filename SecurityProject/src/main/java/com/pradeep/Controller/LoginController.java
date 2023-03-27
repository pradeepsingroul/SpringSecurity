package com.pradeep.Controller;

import com.pradeep.Model.Student;
import com.pradeep.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("/students/signin")
    public ResponseEntity<Student> getloggenInStudentDetailsHandler(Authentication auth){
        Optional<Student> student = studentRepository.findByEmail(auth.getName());
        if(student.isPresent()){
            return new ResponseEntity<>(student.get(), HttpStatus.OK);
        }else{
            throw new BadCredentialsException("Student does not exist..");
        }
    }
}
