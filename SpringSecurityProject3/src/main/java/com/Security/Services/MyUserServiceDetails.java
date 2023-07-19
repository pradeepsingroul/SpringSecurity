package com.Security.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Security.Models.Employee;
import com.Security.Repository.EmployeeRepo;

@Service
public class MyUserServiceDetails implements UserDetailsService{

	@Autowired
	private EmployeeRepo emplRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee empl = emplRepo.findByEmail(username);
		if(empl != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			return new User(empl.getEmail(),empl.getPassword(),authorities);
		}else {
			throw new UsernameNotFoundException("User does not exit with :"+username);
		}
	}

}
