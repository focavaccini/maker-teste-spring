package com.maker.exercicioquatro.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.maker.exercicioquatro.entities.Product;
import com.maker.exercicioquatro.entities.Sku;
import com.maker.exercicioquatro.exceptions.ObjectNotFound;
import com.maker.exercicioquatro.exceptions.UniqueException;
import com.maker.exercicioquatro.repositories.SkuRepository;
import com.maker.exercicioquatro.services.SkuService;

@Service
public class SkuServiceImpl implements SkuService{
	
	@Autowired
	private SkuRepository skuRepository;
	
	@Override
	public void insertFromProduct(Product product) {
		
		for(Sku skuUpdate : product.getSkus()) {
			Sku sku = findById(skuUpdate.getId());
			sku.setProduct(product);
		}
		
	}
	
	@Override
	public void updateFromProduct(Product product) {
		for(Sku skuUpdate : product.getSkus()) {
			Sku skuManage = skuRepository.findById(skuUpdate.getId()).get();
			skuManage.setProduct(product);
		}
		
	}

	@Override
	public Sku findById(Long idSku) {
		Optional<Sku> sku = skuRepository.findById(idSku);
		
		return sku.orElseThrow(() -> new ObjectNotFound("Object not found! Id " + idSku + ", Type: " + Sku.class.getName()));
		
	}

	@Override
	public List<Sku> findAll() {
		
		return skuRepository.findAll();
		
	}

	@Override
	public void validateCodeBar(Sku sku) {
		List<Sku> skus = findAll();
		
		for (Sku obj : skus) {
			
			if(obj.getCodigoBarra().equals(sku.getCodigoBarra())) {
				
				throw new UniqueException("Invalid Request! Id " + obj.getId() + ", Type: " + Sku.class.getName());
			}
			
		}
	}
	
	@Override
	public void validateCodeBarUpdate(Sku sku) {
		List<Sku> skusManaged = findAll();
		
		for (Sku obj : skusManaged) {
			
				if(obj.getCodigoBarra().equals(sku.getCodigoBarra()) && !obj.getId().equals(sku.getId())) {
					throw new UniqueException("Object not found! Id " + obj.getId() + ", Type: " + Sku.class.getName());
				}
			
		}
	}
}
