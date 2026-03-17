package com.e_mart.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.e_mart.Entity.User.MyUser;
import com.e_mart.Entity.User.USER_ROLE;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MyUserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		MyUser user=userService.getUserByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found with "+username+" username");
		}
		USER_ROLE role=user.getRole();
		if(role==null)
			role=USER_ROLE.ROLE_USER;
		List<GrantedAuthority> authority=new ArrayList<>();
		authority.add(new SimpleGrantedAuthority(role.toString()));
		
		
		return new User(user.getUsername(),user.getPassword(),authority);
	}

}
