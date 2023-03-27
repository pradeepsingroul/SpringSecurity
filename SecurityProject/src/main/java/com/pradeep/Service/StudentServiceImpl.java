package com.pradeep.Service;

import com.pradeep.Exceptions.SttudentExceptions;
import com.pradeep.Model.Student;
import com.pradeep.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository srepo;

    @Override
    public Student getStudentByEmailHandler(String email) throws SttudentExceptions {
        Optional<Student> students = srepo.findByEmail(email);
        if(students.isPresent()){
            return students.get();
        }else{
            throw new SttudentExceptions("student does not exist with the email :"+email);
        }
    }

    @Override
    public Student registerStudentHandler(Student student) throws SttudentExceptions {
        Optional<Student> students = srepo.findByEmail(student.getEmail());
        if(students.isPresent()){
            throw new SttudentExceptions("student already exist with the email :"+student.getEmail());
        }else{
           return srepo.save(student);
        }
    }

    @Override
    public List<Student> getAllStudentHandler() throws SttudentExceptions {
//        return srepo.findAll();
        List<Student> students = srepo.findAll();
        if(students.isEmpty()){
            throw new SttudentExceptions("student not found");
        }else{
            return students;
        }
    }
}
