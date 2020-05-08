package com.chetan.hibernateboot.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chetan.hibernateboot.entity.Employee;
import com.sun.org.slf4j.internal.LoggerFactory;

@Repository
public interface EmpDao extends JpaRepository<Employee,Integer> {
	
	public Employee findByUsername(String username);
	
}
