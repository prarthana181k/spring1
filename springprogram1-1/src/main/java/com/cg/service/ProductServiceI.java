package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.entity.Product;

@Service
public interface ProductServiceI {
	public Product addProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getById(int id);
	
	public void deleteById(int id);

	//public Product getByNameAndCatogory(String name, String catogory);
}
