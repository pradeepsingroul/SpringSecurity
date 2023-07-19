package com.Security.Services;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
public class myUserDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeRepo emplRepo;
	
	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Employee> opt = emplRepo.findByEmail(username);
		if(opt.isEmpty()) {
			throw new UsernameNotFoundException("User does not eit with email :"+username);
		}else {
			Employee empl = opt.get();
			List<GrantedAuthority> authorities = new ArrayList<>();
			return new User(empl.getEmail(),empl.getPassword(),authorities);
		}
	}

}
