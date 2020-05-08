package com.chetan.hibernateboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chetan.hibernateboot.dao.EmpDao;
import com.chetan.hibernateboot.entity.Employee;



@RestController
public class EmpController {
	@Autowired
    EmpDao dao;
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployee() {
		
		List<Employee> emp=dao.findAll();		
	for(Employee emp1:emp) {
		System.out.println(emp1.getName());
	}
		return emp;
	
		
	}
	
	
}
