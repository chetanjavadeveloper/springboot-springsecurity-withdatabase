package com.chetan.hibernateboot.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.hibernateboot.dao.EmpDao;
import com.chetan.hibernateboot.entity.Employee;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService{
@Autowired
	EmpDao empDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Employee emp=empDao.findByUsername(username);
		 return new org.springframework.security.core.userdetails.User(emp.getUsername(),
	                emp.getPassword(),
	                mapRolesToAuthorities(emp.getRole()));
	    }

	    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String roles){
	    	List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
	    	auths.add(new SimpleGrantedAuthority(roles));
	    	return auths;
	    }

}
