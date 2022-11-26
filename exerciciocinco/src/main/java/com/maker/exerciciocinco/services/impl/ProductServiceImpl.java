package com.maker.exerciciocinco.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maker.exerciciocinco.entities.Product;
import com.maker.exerciciocinco.entities.Sku;
import com.maker.exerciciocinco.exceptions.DataIntegrityException;
import com.maker.exerciciocinco.exceptions.NotFoundException;
import com.maker.exerciciocinco.exceptions.ObjectNotFound;
import com.maker.exerciciocinco.repositories.ProductRepository;
import com.maker.exerciciocinco.services.ProductService;
import com.maker.exerciciocinco.services.SkuService;
import com.maker.exerciciocinco.utils.Util;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SkuService skuService;
	
	@Override
	@Transactional
	public Product insert(Product product) {
		
		validateSku(product);
		
		for(Sku sku : product.getSkus()) skuService.validateCodeBar(sku);
		
		product = productRepository.save(product);
		
		for(int i = 0; i < product.getSkus().size(); i++) {
			skuService.insertFromProduct(product);
		}
		
		return product;
	}

	@Override
	@Transactional
	public void update(Long idProduct, Product product) {
		Product productManaged = findById(idProduct);
		
		validateSku(product);
		
		productManaged.setMarca(Util.nvl(product.getMarca(), productManaged.getMarca()));
		productManaged.setDepartamento(Util.nvl(product.getDepartamento(), productManaged.getDepartamento()));
		productManaged.setDescricao(Util.nvl(product.getDescricao(), productManaged.getDescricao()));
		productManaged.setQuantidadeEstoque(Util.nvl(product.getQuantidadeEstoque(), productManaged.getQuantidadeEstoque()));
		productManaged.setImagens(Util.nvl(product.getImagens(), productManaged.getImagens()));
		
		productManaged.setSkus(Util.nvl(product.getSkus(), productManaged.getSkus()));
		productManaged = productRepository.save(productManaged);
		
		
	}

	@Override
	public Product findById(Long idProduct) {
		Optional<Product> sku = productRepository.findById(idProduct);
		
		return sku.orElseThrow(() -> new ObjectNotFound("Object not found! Id " + idProduct + ", Type: " + Product.class.getName()));
	}

	@Override
	public List<Product> findAll() {
	
		return productRepository.findAll();
	}

	@Override
	public void delete(Long idProduct) {
		findById(idProduct);
		try {
			productRepository.deleteById(idProduct);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Cannot delete");
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Product updateProductFromUrl(Long idProduct) throws ClassNotFoundException {
		Product productManaged = findById(idProduct);
		
		 Map<String, String> dados = new HashMap<>();
		try {
			String urlGet = "https://mockbin.org/bin/fd9103a1-81dc-4a5d-88c3-dd9f8eaf2661";
		

            URL objUrl = new URL(urlGet);
            HttpURLConnection con = (HttpURLConnection) objUrl.openConnection();
            con.setRequestMethod("GET");
            
            int responseCode = con.getResponseCode();

            if (responseCode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
             
                String descricao = br.readLine();
                ObjectMapper mapper = new ObjectMapper();
                 dados = mapper.readValue(descricao, Map.class);  
            }
		} catch (IOException e) {

			e.printStackTrace();
		}

		return updateProduct(productManaged, dados);
	}
	

	private Product updateProduct(Product productManaged,  Map<String, String> dados) throws ClassNotFoundException{
		
		try {
			
            Class<?> c = Class.forName("com.maker.exerciciocinco.entities.Product");
            Field[] atributos= c.getDeclaredFields();

	            for(Field fields : atributos) {

	            	if(dados.containsKey(fields.getName())) {
	            		productManaged.setDescricao(Util.nvl(dados.get(fields.getName()), productManaged.getDescricao()));

	            	}
		         }
		}
         catch (Throwable e) {
            System.err.println(e);
         }
		return productRepository.save(productManaged);
	}
	
	
	private void validateSku(Product product) {
		
		if(product.getSkus().size() == 0) {
			throw new NotFoundException("Sku cannot be null! Id " + product.getId() + ", Type: " + Product.class.getName());
		}
	}
}
