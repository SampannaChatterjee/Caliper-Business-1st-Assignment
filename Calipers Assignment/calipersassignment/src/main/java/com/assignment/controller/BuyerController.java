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

import com.assignment.model.Buyer;
import com.assignment.service.BuyerService;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
	
	@Autowired
	private BuyerService bService;
	
	@PostMapping("/add")
	public ResponseEntity<Buyer> addBuyerController(@RequestBody Buyer buyer){
		Buyer b=bService.addBuyer(buyer);
		return new ResponseEntity<Buyer>(b,HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{buyerId}/{buyerName}/{contact}/{address}")
	public ResponseEntity<Buyer> updateBuyerController(@PathVariable Integer buyerId,@PathVariable String buyerName,@PathVariable Integer contact, @PathVariable String address){
		Buyer b=bService.updateBuyer(buyerId,buyerName,contact,address);
		return new ResponseEntity<Buyer>(b,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{buyerId}")
	public ResponseEntity<String> deleteBuyerController(@PathVariable Integer buyerId){
		Buyer b=bService.deleteBuyer(buyerId);
		return new ResponseEntity<String>("Buyer deleted with id"+" "+b.getBuyerId(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Buyer>> getAllBuyers(){
		List<Buyer> list=bService.getAllBuyers();
		return new ResponseEntity<List<Buyer>>(list,HttpStatus.ACCEPTED);
	}

}
