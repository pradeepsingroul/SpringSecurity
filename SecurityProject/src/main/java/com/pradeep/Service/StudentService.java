package com.pradeep.Service;

import com.pradeep.Exceptions.SttudentExceptions;
import com.pradeep.Model.Student;

import java.util.List;

public interface StudentService{

    public Student getStudentByEmailHandler(String email) throws SttudentExceptions;

    public Student registerStudentHandler(Student student) throws SttudentExceptions;

    public List<Student> getAllStudentHandler( ) throws SttudentExceptions;

}
