package com.pradeep.Controller;

import com.pradeep.Model.Student;
import com.pradeep.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/hello")
    public String sayHello(){
        String message = "welcome to the spring security project";
        return message;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        Student student1 = studentService.registerStudentHandler(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);

    }
    @GetMapping("/students/{email}")
    public ResponseEntity<Student> getStudentById(@PathVariable(name = "email") String email){
        Student student1 = studentService.getStudentByEmailHandler(email);
        return new ResponseEntity<>(student1, HttpStatus.OK);

    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudentById(){

        List<Student> studentList = studentService.getAllStudentHandler();
        return new ResponseEntity<>(studentList,HttpStatus.OK);
    }
}
