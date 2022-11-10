package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.Services;
import com.assignment.service.ServicesService;

@RestController
@RequestMapping("/services")
public class ServicesController {
	
	@Autowired
	private ServicesService sService;
	
	@PostMapping("/addService")
	public ResponseEntity<Services> addServiceController(@RequestBody Services s){
		Services serve=sService.addService(s);
		return new ResponseEntity<Services>(serve,HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/updateService")
	public ResponseEntity<Services> updateServiceController(@RequestBody Services s){
		Services serve=sService.updateService(s);
		return new ResponseEntity<Services>(serve,HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{serviceId}")
	public ResponseEntity<Services> deleteServiceController(@PathVariable Integer serviceId){
		Services serve=sService.deleteService(serviceId);
		return new ResponseEntity<Services>(serve,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/get/{serviceId}")
	public ResponseEntity<Services> getServiceController(@PathVariable Integer serviceId){
		Services serve=sService.viewService(serviceId);
		return new ResponseEntity<Services>(serve,HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Services>> getServiceController(){
		List<Services> serve=sService.getAllServices();
		return new ResponseEntity<List<Services>>(serve,HttpStatus.ACCEPTED);
		
	}

}
