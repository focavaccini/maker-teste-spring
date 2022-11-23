package com.maker.exercicioum.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Sku implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String codigoBarra;
	
	private List<Image> imagens;

	public Sku(Long id, String codigoBarra, List<Image> imagens) {
		super();
		this.id = id;
		this.codigoBarra = codigoBarra;
		this.imagens = imagens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public List<Image> getImagens() {
		return imagens;
	}

	public void setImagens(List<Image> imagens) {
		this.imagens = imagens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoBarra, id, imagens);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sku other = (Sku) obj;
		return Objects.equals(codigoBarra, other.codigoBarra) && Objects.equals(id, other.id)
				&& Objects.equals(imagens, other.imagens);
	}
	
}
