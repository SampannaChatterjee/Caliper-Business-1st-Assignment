package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignment.exception.SellerException;
import com.assignment.model.Product;
import com.assignment.model.Seller;
import com.assignment.repository.ProductDao;
import com.assignment.repository.SellerDao;

public class SellerServiceImpl implements SellerService{
	
	@Autowired
	SellerDao sDao;
	
	@Autowired
	ProductDao pDao;
	
	@Override
	public Seller addSeller(Seller seller) {
		
		Seller s=sDao.getById(seller.getSellerId());
		if(s!=null) {
			throw new SellerException("Seller already exists");
		}else {
			return sDao.save(seller);
		}
	}

	@Override
	public Seller updateSeller(Integer sellerId,String name,Integer contact,String address,List<Product> plist) {
		
		Seller s=sDao.getById(sellerId);
		if(s==null) {
			throw new SellerException("Seller not found");
		}else {
			if(name.length()!=0) {
				s.setSellerName(name);
			}
			if(contact!=0) {
				s.setContactNumber(contact);
			}
			if(address.length()!=0) {
				s.setSellerAddress(address);
			}
			if(plist.size()!=0) {
				for(Product p:plist) {
					s.getProducts().add(p);
				}
			}
			sDao.save(s);
			return s;
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
	public Seller viewSeller(Integer sellerId) {
		
		Seller s=sDao.getById(sellerId);
		if(s==null) {
			throw new SellerException("Seller does not exists");
		}else {
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
