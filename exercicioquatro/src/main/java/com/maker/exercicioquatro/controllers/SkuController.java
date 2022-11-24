package com.maker.exercicioquatro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maker.exercicioquatro.controllers.interfaces.ISkuController;
import com.maker.exercicioquatro.converter.Converter;
import com.maker.exercicioquatro.dtos.SkuDTO;
import com.maker.exercicioquatro.services.SkuService;

@RestController
@RequestMapping("/sku")
public class SkuController implements ISkuController{
	
	@Autowired
	private SkuService skuService;
	
	@Autowired
	private Converter converter;

	@Override
	public SkuDTO findById(Long idSku) {
		
		return converter.convert(skuService.findById(idSku), SkuDTO.class);
	}
	
	@Override
	public List<SkuDTO> findAll() {
		return converter.convert(skuService.findAll(), SkuDTO.class);
	}

}
