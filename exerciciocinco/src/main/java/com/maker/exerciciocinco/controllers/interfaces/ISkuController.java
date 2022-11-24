package com.maker.exerciciocinco.controllers.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.maker.exerciciocinco.dtos.SkuDTO;

public interface ISkuController {
	
	@GetMapping(value="/{id}")
	SkuDTO findById(@PathVariable("id") Long idSku);
	
	@GetMapping(value = "/findAll")
	List<SkuDTO> findAll();
}
