package com.maker.exercicioquatro.controllers.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.maker.exercicioquatro.dtos.SkuDTO;

public interface ISkuController {
	
	@GetMapping(value="/{id}")
	SkuDTO findById(@PathVariable("id") Long idSku);
	
	@GetMapping(value = "/findAll")
	List<SkuDTO> findAll();
}
