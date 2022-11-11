package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Product;
import com.assignment.model.Seller;
import com.assignment.service.SellerService;

@RestController
@RequestMapping("/seller")
public class SellerController {
	
	@Autowired
	private SellerService sService;
	
	@PostMapping("/add")
	public ResponseEntity<Seller> addSellerController(@RequestBody Seller s){
		Seller seller = sService.addSeller(s);
		return new ResponseEntity<Seller>(seller,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{sellerId}/{name}/{contact}/{address}/{plist}")
	public ResponseEntity<Seller> updateSellerController(@PathVariable Integer sellerId,@PathVariable String name,@PathVariable Integer contact, @PathVariable String address,@PathVariable Product[] plist){
		Seller seller=sService.updateSeller(sellerId, name, contact, address, plist);
		return new ResponseEntity<Seller>(seller,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{sellerId}")
	public ResponseEntity<String> deleteSellerController(@PathVariable Integer sellerId){
		Seller s=sService.deleteSeller(sellerId);
		return new ResponseEntity<String>("Seller deleted with id"+" "+s.getSellerId(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAllSellers")
	public ResponseEntity<List<Seller>> getAllSellersController(){
		List<Seller> slist=sService.viewAllSellers();
		return new ResponseEntity<List<Seller>>(slist,HttpStatus.ACCEPTED);
	}

}
