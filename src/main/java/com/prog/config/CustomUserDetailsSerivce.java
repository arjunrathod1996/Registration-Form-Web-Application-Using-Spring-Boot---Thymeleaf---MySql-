package com.prog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.prog.repository.UserRepository;

public class CustomUserDetailsSerivce implements UserDetailsService{

	
	@Autowired
	private UserRepository repo;
	
	
	@Override
	public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {
		
		try {
			com.prog.entity.UserDetails u = repo.findByEmail(em);
				if(u ==null) {
					throw new UsernameNotFoundException("No User");
				}else {
					return new CustomUserDetails(u);
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
