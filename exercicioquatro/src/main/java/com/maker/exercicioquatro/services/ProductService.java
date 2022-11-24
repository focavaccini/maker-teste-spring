package com.maker.exercicioquatro.services;

import java.util.List;

import com.maker.exercicioquatro.entities.Product;

public interface ProductService {
	Product insert(Product product);
	
	void update(Long idProduct, Product product);
	
	Product findById(Long idProduct);
	
	List<Product> findAll();
	
	void delete(Long idProduct);
}
