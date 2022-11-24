package com.maker.exerciciocinco.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.maker.exerciciocinco.controllers.interfaces.IProductController;
import com.maker.exerciciocinco.converter.Converter;
import com.maker.exerciciocinco.dtos.ProductDTO;
import com.maker.exerciciocinco.entities.Product;
import com.maker.exerciciocinco.services.ProductService;

@RestController
public class ProductController implements IProductController{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private Converter converter;
	
	@Override
	public ProductDTO insert(ProductDTO productDTO) {
		// TODO Auto-generated method stub
		Product product = converter.convert(productDTO, Product.class);
		return converter.convert(productService.insert(product), ProductDTO.class);
	}

	@Override
	public ProductDTO findById(Long idProduct) {
		// TODO Auto-generated method stub
		return converter.convert(productService.findById(idProduct), ProductDTO.class);
	}

	@Override
	public void update(Long idProduct, ProductDTO productDTO) {
		Product product = converter.convert(productDTO, Product.class);
		productService.update(idProduct, product);
		
	}

	@Override
	public void delete(Long idProduct) {
		productService.delete(idProduct);
	}
	
	@Override
	public List<ProductDTO> findAll() {
		return converter.convert(productService.findAll(), ProductDTO.class);
	}
	
	@Override
	public ProductDTO updateProductFromUrl(Long idProduct) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return converter.convert(productService.updateProductFromUrl(idProduct), ProductDTO.class);
	}
}
