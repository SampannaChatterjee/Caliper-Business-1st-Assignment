package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Buyer;

@Repository
public interface BuyerDao extends JpaRepository<Buyer, Integer>{
	
	public Buyer getById(Integer buyerId);

}
