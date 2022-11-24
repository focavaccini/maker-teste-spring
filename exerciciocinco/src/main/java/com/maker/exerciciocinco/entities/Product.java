package com.maker.exerciciocinco.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_product")
@EqualsAndHashCode
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_product")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "descricao", length = 50, nullable = false)
	private String descricao;
	
	@Column(name = "marca", length = 50, nullable = false)
	private String marca;
	
	@Column(name = "departamento", length = 50, nullable = false)
	private String departamento;
	
	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidadeEstoque;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "tb_product_imagens", joinColumns = @JoinColumn(name = "product_id"))
	private List<Image> imagens;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Sku> skus;
	
}
