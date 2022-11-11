package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.exception.SellerException;
import com.assignment.model.Product;
import com.assignment.model.Seller;
import com.assignment.repository.ProductDao;
import com.assignment.repository.SellerDao;

@Service
public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerDao sDao;
	
	@Autowired
	ProductDao pDao;
	
	@Override
	public Seller addSeller(Seller seller) {
		if(seller==null) {
			throw new SellerException("Please add seller details");
		}else {
			return sDao.save(seller);
		}
	}

	@Override
	public Seller deleteSeller(Integer sellerId) {
		Seller s=sDao.getById(sellerId);
		if(s==null) {
			throw new SellerException("Seller does not exists");
		}else {
			sDao.delete(s);
			return s;
		}
	}

	@Override
	public List<Seller> viewAllSellers() {
		List<Seller> l=sDao.findAll();
		if(l.size()==0) {
			throw new SellerException("No Seller exists");
		}else {
			return l;
		}
	}

}
