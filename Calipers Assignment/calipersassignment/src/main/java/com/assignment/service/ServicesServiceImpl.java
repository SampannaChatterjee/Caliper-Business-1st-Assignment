package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exception.ServiceException;
import com.assignment.model.Services;
import com.assignment.repository.ServicesDao;

@Service
public class ServicesServiceImpl implements ServicesService{
	
	@Autowired
	ServicesDao sDao;
	
	@Override
	public Services addService(Services service) {
		if(service==null) {
			throw new ServiceException("Please add service details");
		}else {
			return sDao.save(service);
		}
	}

	@Override
	public Services updateService(Integer serviceId, String serviceName) {
		Services s = sDao.getById(serviceId);
		if(s==null) {
			throw new ServiceException("No service found");
		}else {
			s.setServiceName(serviceName);
			return sDao.save(s);
		}
	}

	@Override
	public Services deleteService(Integer serviceId) {
		Services s=sDao.getById(serviceId);
		if(s==null) {
			throw new ServiceException("No service found");
		}else {
			sDao.delete(s);
			return s;
		}
	}

	@Override
	public List<Services> getAllServices() {
		List<Services> slist=sDao.findAll();
		return slist;
	}

}
