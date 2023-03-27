package com.pradeep.Service;

import com.pradeep.Model.Student;
import com.pradeep.Repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> optionalStudent = studentRepository.findByEmail(username);
        if (optionalStudent.isPresent()){
            Student s1 = optionalStudent.get();
            List<GrantedAuthority> authorities = new ArrayList<>();

            return new User(s1.getEmail(),s1.getPassword(),authorities);
        }else throw new BadCredentialsException("User details not found with this userName :"+username);
    }
}
