package com.maker.exercicioquatro.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.maker.exercicioquatro.entities.Product;
import com.maker.exercicioquatro.entities.Sku;
import com.maker.exercicioquatro.exceptions.DataIntegrityException;
import com.maker.exercicioquatro.exceptions.ObjectNotFound;
import com.maker.exercicioquatro.repositories.ProductRepository;
import com.maker.exercicioquatro.services.ProductService;
import com.maker.exercicioquatro.services.SkuService;
import com.maker.exercicioquatro.utils.Util;
import com.maker.exercicioquatro.validators.ValidateEntityFields;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SkuService skuService;
	
	private ValidateEntityFields validate = new ValidateEntityFields();
	
	@Override
	@Transactional
	public Product insert(Product product) {
		
		validate.ValidateEntity(product);
		
		for(Sku sku : product.getSkus()) {
			skuService.validateCodeBar(sku);
		}
		
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
		
		validate.ValidateEntity(product);
		
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
}
