package com.chainsys.product.dao;

import java.util.Set;
import java.time.LocalDate;
import java.util.List;

import com.chainsys.product.model.Product;

public interface ProductDAO {
	Set<Product> findAll();
	
	public List<String> ViewAllProductName();
	
	public List<Integer> ViewAllProductId();

	Product findById(int id);
	
	Product findByName(String name);
	
	Product findByDate(LocalDate date);
	
	void save(Product product);

	void update(Product product);
	
	void updateExpire(Product product);

	void delete(int id);
	
	void deleteByName(String name);
	
	void deleteByDate(LocalDate date);
	
	
}
