package com.maker.exercicioquatro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.maker.exercicioquatro.controllers.interfaces.IProductController;
import com.maker.exercicioquatro.converter.Converter;
import com.maker.exercicioquatro.dtos.ProductDTO;
import com.maker.exercicioquatro.entities.Product;
import com.maker.exercicioquatro.services.ProductService;

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
	
}
