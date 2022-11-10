package com.assignment.service;
import java.util.*;

import com.assignment.model.Product;
import com.assignment.model.Seller;

public interface SellerService {
	
	public Seller addSeller(Seller seller);
	
	public Seller updateSeller(Integer sellerId,String name,Integer contact,String address,List<Product> plist);
	
	public Seller deleteSeller(Integer sellerId);
	
	public Seller viewSeller(Integer sellerId);
	
	public List<Seller> viewAllSellers();
	
	

}
