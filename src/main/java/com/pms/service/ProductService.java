package com.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.model.Products;
import com.pms.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrepository;
	
	public List<Products> getAllProducts(){
		return productrepository.findAll();
	}
	
	public Products createProduct(Products pd) {
		productrepository.save(pd);
		return pd;
	}
	
	public Products deleteProduct(String pName) {
		try {
			Products pd=productrepository.getProductByPnameIgnoreCase(pName);
			productrepository.delete(pd);
			return pd;
		}catch(Exception e){
			return null;
		}

	}
	
	public Products getProductById(Long pId) {
		Products product=productrepository.findById(pId).get();
		return product;
	}
	
	public Products findProductByNameIgnorecase(String pName) {
		return productrepository.getProductByPnameIgnoreCase(pName);
	}
	
	public void updateProduct(Products p,Long pId) {
		Products product=productrepository.findById(pId).get();
		product.setpId(p.getpId());
		product.setpName(p.getpName());
		product.setPrice(p.getPrice());
		
	}
	
}
