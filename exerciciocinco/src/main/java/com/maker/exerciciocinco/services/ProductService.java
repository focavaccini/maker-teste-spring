package com.maker.exerciciocinco.services;

import java.util.List;

import com.maker.exerciciocinco.entities.Product;

public interface ProductService {
	Product insert(Product product);
	
	void update(Long idProduct, Product product);
	
	Product findById(Long idProduct);
	
	List<Product> findAll();
	
	void delete(Long idProduct);
	
	Product updateProductFromUrl(Long idProduct) throws ClassNotFoundException;
}
