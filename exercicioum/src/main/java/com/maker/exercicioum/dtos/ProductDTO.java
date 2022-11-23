package com.maker.exercicioum.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ProductDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String descricao;
	
	private String marca;
	
	private String departamento;
	
	private Integer quantidadeEstoque;
	
	private List<ImageDTO> imagens;
	
	private List<SkuDTO> skus;

	public ProductDTO(Long id, String descricao, String marca, String departamento, Integer quantidadeEstoque,
			List<ImageDTO> imagens, List<SkuDTO> skus) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.marca = marca;
		this.departamento = departamento;
		this.quantidadeEstoque = quantidadeEstoque;
		this.imagens = imagens;
		this.skus = skus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public List<ImageDTO> getImagens() {
		return imagens;
	}

	public void setImagens(List<ImageDTO> imagens) {
		this.imagens = imagens;
	}

	public List<SkuDTO> getSkus() {
		return skus;
	}

	public void setSkus(List<SkuDTO> skus) {
		this.skus = skus;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departamento, descricao, id, imagens, marca, quantidadeEstoque, skus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(imagens, other.imagens)
				&& Objects.equals(marca, other.marca) && Objects.equals(quantidadeEstoque, other.quantidadeEstoque)
				&& Objects.equals(skus, other.skus);
	}
}
