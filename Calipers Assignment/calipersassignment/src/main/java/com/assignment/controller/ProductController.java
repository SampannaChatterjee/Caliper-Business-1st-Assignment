package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Product;
import com.assignment.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService pService;
	
	@PostMapping("/addproduct")
	public ResponseEntity<Product> saveProductController(@RequestBody Product product){
		Product p=pService.addProduct(product);
		return new ResponseEntity<Product>(p,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateproduct/{productId}/{name}/{quantity}")
	public ResponseEntity<Product> updateProductController(@PathVariable Integer productId,@PathVariable String name,@PathVariable Integer quantity){
		Product p=pService.updateProduct(productId,name,quantity);
		return new ResponseEntity<Product>(p,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteproduct/{productId}")
	public ResponseEntity<String> deleteProductHandler(@PathVariable Integer productId){
		Product p=pService.deleteProduct(productId);
		return new ResponseEntity<String>("Product deleted with id"+" "+productId,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getProductList(){
		List<Product> pList=pService.viewAllProducts();
		return new ResponseEntity<List<Product>>(pList,HttpStatus.ACCEPTED);
	}
	
	
	
	

}
