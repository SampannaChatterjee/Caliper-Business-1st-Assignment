package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exception.ProductException;
import com.assignment.model.Product;
import com.assignment.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	public ProductDao pDao;
	
	@Override
	public Product addProduct(Product product) {
		//Product p=pDao.getById(product.getProductId());
		
		if(product==null) {
			throw new ProductException("Enter product details");
		}else {
			return pDao.save(product);
		}
	}

	@Override
	public Product updateProduct(Integer productId, String name, Integer quantity) {
		Product p=pDao.getById(productId);
		
		if(p==null) {
			throw new ProductException("No product found with product ID"+" "+productId);
		}else {
			if(p.getProductName().equals(name)==true) {
				p.setQuantity(p.getQuantity()+quantity);
			}else {
				p.setProductName(name);
				p.setQuantity(quantity);
			}
			return pDao.save(p);
		}
		
	}

	@Override
	public Product deleteProduct(Integer productId) {
		Product p=pDao.getById(productId);
		
		if(p==null) {
			throw new ProductException("No product found with product ID"+" "+productId);
		}else {
			pDao.delete(p);
			return p;
		}
		
	}

	@Override
	public List<Product> viewAllProducts() {
		List<Product> productList=pDao.findAll();
		if(productList==null) {
			throw new ProductException("No products available");
		}else {
			return productList;
		}
	}
	
	

}
