package com.maker.exerciciocinco.controllers.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maker.exerciciocinco.dtos.ProductDTO;

@RequestMapping("/product")
public interface IProductController {
	
	@PostMapping
	ProductDTO insert(@RequestBody ProductDTO productDTO);
	
	@GetMapping(value = "/{id}")
	ProductDTO findById(@PathVariable("id") Long idProduct);
	
	@PutMapping(value = "/{id}")
	void update(@PathVariable("id") Long idProduct, @RequestBody ProductDTO productDTO);
	
	@DeleteMapping(value = "/{id}")
	void delete(@PathVariable("id") Long idProduct);
	
	@GetMapping("/findAll")
	List<ProductDTO> findAll();
	
	@PutMapping("/update-from-url/{id}")
	ProductDTO updateProductFromUrl(@PathVariable("id") Long idProduct) throws ClassNotFoundException;
}
