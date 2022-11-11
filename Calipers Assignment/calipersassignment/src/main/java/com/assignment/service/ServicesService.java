package com.assignment.service;
import java.util.*;

import com.assignment.model.Services;

public interface ServicesService {
	
	public Services addService(Services service);
	
	public Services updateService(Integer serviceId, String serviceName);
	
	public Services deleteService(Integer serviceId);
	
	public List<Services> getAllServices();
	
}
