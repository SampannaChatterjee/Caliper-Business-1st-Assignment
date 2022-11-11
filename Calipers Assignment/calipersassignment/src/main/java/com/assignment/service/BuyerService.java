package com.assignment.service;

import java.util.*;

import com.assignment.model.Buyer;


public interface BuyerService {
	
	public Buyer addBuyer(Buyer buyer);
	
	public Buyer updateBuyer(Integer buyerId,String buyerName,Integer contact,String address);
	
	public Buyer deleteBuyer(Integer buyerId);
	
	public List<Buyer> getAllBuyers();
}
