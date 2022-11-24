package com.maker.exerciciocinco.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_sku")
public class Sku {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_sku")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "codigo_barra", length = 50, nullable = false)
	private String codigoBarra;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "tb_sku_imagens", joinColumns = @JoinColumn(name = "sku_id"))
	private List<Image> imagens;
}
