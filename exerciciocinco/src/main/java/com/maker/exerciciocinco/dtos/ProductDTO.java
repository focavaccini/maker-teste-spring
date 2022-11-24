package com.maker.exerciciocinco.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;
	
	private String marca;
	
	private String departamento;
	
	private Integer quantidadeEstoque;
	
	private List<ImageDTO> imagens;
	
	private List<SkuDTO> skus;

}
