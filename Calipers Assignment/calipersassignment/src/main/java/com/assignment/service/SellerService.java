package com.assignment.service;
import java.util.*;

import com.assignment.model.Product;
import com.assignment.model.Seller;

public interface SellerService {
	
	public Seller addSeller(Seller seller);
	
	public Seller updateSeller(Integer sellerId,String name,Integer contact,String address,Product[] plist);
	
	public Seller deleteSeller(Integer sellerId);
	
	public List<Seller> viewAllSellers();
	
	

}
