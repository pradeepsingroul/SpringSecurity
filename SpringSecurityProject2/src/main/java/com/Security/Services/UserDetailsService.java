package com.Security.Services;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Security.Models.Employee;
import com.Security.Repository.EmployeeRepo;

@Service
public class UserDetailsService {
	
	@Autowired
	private EmployeeRepo emplRepo;
	
	
	public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException{
		Employee opt = emplRepo.findByEmail(userName);
		if(opt==null) {
			throw new UsernameNotFoundException("User does not eit with email :"+userName);
		}else {
			List<GrantedAuthority> authorities = new ArrayList<>();
			return new User(opt.getEmail(),opt.getPassword(),authorities);
		}
	}

}
