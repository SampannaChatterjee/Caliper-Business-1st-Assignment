package com.assignment.service;
import java.util.*;

import com.assignment.model.Product;

public interface ProductService {
	
	public Product addProduct(Product product);
	public Product updateProduct(Integer productId, String name, Integer quantity);
	public Product deleteProduct(Integer productId);
	public Product viewProduct(Integer productId);
	public List<Product> viewAllProducts();
	

}
