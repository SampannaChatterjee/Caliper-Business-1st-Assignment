package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exception.BuyerException;
import com.assignment.exception.ProductException;
import com.assignment.exception.ServiceException;
import com.assignment.model.Buyer;
import com.assignment.model.Product;
import com.assignment.model.Services;
import com.assignment.repository.BuyerDao;
import com.assignment.repository.ProductDao;
import com.assignment.repository.ServicesDao;

@Service
public class BuyerServiceImpl implements BuyerService{
	
	@Autowired
	BuyerDao bDao;
	
	@Autowired
	ProductDao pDao;
	@Autowired
	ServicesDao sDao;
	@Override
	public Buyer addBuyer(Buyer buyer) {
		if(buyer==null) {
			throw new BuyerException("Please add details of the buyer");
		}else {
			
			for(Product p:buyer.getProducts()) {
				Product a=pDao.findByproductName(p.getProductName());
				if(a==null) {
					throw new ProductException(p.getProductName()+" "+"Does not exists");
				}
				else {
					if(p.getQuantity()!=0) {
						a.setQuantity(a.getQuantity()-p.getQuantity());
						pDao.save(a);
					}
					continue;
				}
				
			}
			for(Services s:buyer.getServices()) {
				Services a=sDao.findByserviceName(s.getServiceName());
				if(a==null) {
					throw new ServiceException(s.getServiceName()+" "+"Does not exists");
				}else {
					continue;
				}
				
			}
			return bDao.save(buyer);
		}
	}

	@Override
	public List<Buyer> getAllBuyers() {
		List<Buyer> b=bDao.findAll();
		return b;
	}

	@Override
	public Buyer updateBuyer(Integer buyerId, String buyerName, Integer contact, String address) {
		Buyer b=bDao.getById(buyerId);
		if(b==null) {
			throw new BuyerException("Buyer does not exists");
		}else {
			if(buyerName.length()!=0) {
				b.setBuyerName(buyerName);
			}
			if(contact!=0) {
				b.setContactNumber(contact);
			}
			if(address.length()!=0) {
				b.setBuyerAddress(address);
			}
			bDao.save(b);
			return b;
		}
	}

	@Override
	public Buyer deleteBuyer(Integer buyerId) {
		Buyer b=bDao.getById(buyerId);
		if(b==null) {
			throw new BuyerException("Buyer not found");
		}else {
			bDao.delete(b);
			return b;
		}
	}

}
