package com.chainsys.product.service;

import java.util.Set;
import java.time.LocalDate;
import java.util.List;

import com.chainsys.product.exception.ProductNotFoundException;
import com.chainsys.product.model.Product;

public interface ProductService {
	Set<Product> findAll();

	public List<String> ViewAllProductName();
	
	public List<Integer> ViewAllProductId();
	
	Product findById(int id) throws ProductNotFoundException;
	
	Product findByName(String name)throws ProductNotFoundException;
	
	Product findByDate(LocalDate date)throws ProductNotFoundException;
	
	void save(Product Product);

	void update(Product Product) throws ProductNotFoundException;
	
	void updateExpire(Product Product) throws ProductNotFoundException;

	void delete(int id) throws ProductNotFoundException;
	
	void deleteByName(String name) throws ProductNotFoundException;

	void deleteByDate(LocalDate date) throws ProductNotFoundException;

}
