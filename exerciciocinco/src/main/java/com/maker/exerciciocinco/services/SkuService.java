package com.maker.exerciciocinco.services;

import java.util.List;

import com.maker.exerciciocinco.entities.Product;
import com.maker.exerciciocinco.entities.Sku;

public interface SkuService {
	
void insertFromProduct(Product product);
	
	void updateFromProduct(Product product);
	
	Sku findById(Long idSku);
	
	List<Sku> findAll();
	
	void validateCodeBar(Sku sku);

	void validateCodeBarUpdate(Sku sku);
}
