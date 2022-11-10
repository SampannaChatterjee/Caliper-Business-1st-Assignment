package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.exception.ServiceException;
import com.assignment.model.Services;
import com.assignment.repository.ServicesDao;

public class ServicesServiceImpl implements ServicesService{
	
	@Autowired
	ServicesDao sDao;
	
	@Override
	public Services addService(Services service) {
		Services s=sDao.getById(service.getServiceId());
		if(s==null) {
			throw new ServiceException("No service found");
		}else {
			return sDao.save(service);
		}
	}

	@Override
	public Services updateService(Services service) {
		Services s = sDao.getById(service.getServiceId());
		if(s==null) {
			throw new ServiceException("No service found");
		}else {
			sDao.save(service);
			return sDao.getById(service.getServiceId());
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
	public Services viewService(Integer serviceId) {
		Services s=sDao.getById(serviceId);
		if(s==null) {
			throw new ServiceException("No services found");
		}else {
			return s;
		}
	}

	@Override
	public List<Services> getAllServices() {
		List<Services> slist=sDao.findAll();
		return slist;
	}

}
