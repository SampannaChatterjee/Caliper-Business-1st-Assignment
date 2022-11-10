package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exception.BuyerException;
import com.assignment.model.Buyer;
import com.assignment.repository.BuyerDao;

@Service
public class BuyerServiceImpl implements BuyerService{
	
	@Autowired
	BuyerDao bDao;
	
	@Override
	public Buyer addBuyer(Buyer buyer) {
		Buyer b=bDao.getById(buyer.getBuyerId());
		if(b!=null) {
			throw new BuyerException("Buyer Already Exists with ID"+" "+buyer.getBuyerId());
		}else {
			return bDao.save(buyer);
		}
	}

	@Override
	public Buyer getBuyer(Integer buyerId) {
		Buyer b=bDao.getById(buyerId);
		if(b==null) {
			throw new BuyerException("Buyer does not exists");
		}else {
			return b;
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
