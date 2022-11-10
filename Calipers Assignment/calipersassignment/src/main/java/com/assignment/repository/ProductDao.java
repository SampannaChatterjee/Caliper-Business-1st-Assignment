package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{
	
	public Product getById(Integer productId);

}
