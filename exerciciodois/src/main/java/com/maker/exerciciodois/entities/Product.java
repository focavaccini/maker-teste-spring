package com.maker.exerciciodois.entities;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String descricao;
	
	private String marca;
	
	private String departamento;
	
	private Integer quantidadeEstoque;
	
	private List<Image> imagens;
	
	private List<Sku> skus;
}
