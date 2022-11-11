package com.assignment.service;
import java.util.*;

import com.assignment.model.Product;
import com.assignment.model.Seller;

public interface SellerService {
	
	public Seller addSeller(Seller seller);
	
	public Seller deleteSeller(Integer sellerId);
	
	public List<Seller> viewAllSellers();
	
	

}
