package com.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.model.Products;
import com.pms.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(path="/products")
	public ResponseEntity<?> ceateProduct(@RequestBody Products pd) {
		Products product=productService.createProduct(pd);
		if(pd!=null)
		    return new ResponseEntity<Products>(product,HttpStatus.CREATED);
		else
			return  new ResponseEntity<String>("Product Not Found",HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@GetMapping("/products")
	public ResponseEntity<?> getAllProducts() {
		List<Products> product=productService.getAllProducts();
		if(product!=null)
		    return new ResponseEntity<List<Products>>(product,HttpStatus.OK);
		else
			return  new ResponseEntity<String>("Product Not Found",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path="/products/{pName}")
	public ResponseEntity<?> deleteProduct(@PathVariable String pName) {
		Products pd=productService.deleteProduct(pName);
		if(pd!=null)
		    return new ResponseEntity<Products>(pd,HttpStatus.OK);
		else
			return  new ResponseEntity<String>("Product Not Found",HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(path="/products/{pName}")
	public ResponseEntity<?> getProductByName(@PathVariable String pName) {
		Products pd=productService.findProductByNameIgnorecase(pName);
		if(pd!=null)
		    return new ResponseEntity<Products>(pd,HttpStatus.OK);
		else
			return  new ResponseEntity<String>("Product Not Found",HttpStatus.NOT_FOUND);
	}
}
