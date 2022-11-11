package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.model.Services;

public interface ServicesDao extends JpaRepository<Services, Integer>{
	
	public Services getById(Integer serviceId);
	
	public Services findByserviceName(String name);

}
