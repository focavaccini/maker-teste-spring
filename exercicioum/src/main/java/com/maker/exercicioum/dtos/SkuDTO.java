package com.maker.exercicioum.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class SkuDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String codigoBarra;
	
	private List<ImageDTO> images;

	public SkuDTO(Long id, String codigoBarra, List<ImageDTO> images) {
		super();
		this.id = id;
		this.codigoBarra = codigoBarra;
		this.images = images;
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

	public List<ImageDTO> getImages() {
		return images;
	}

	public void setImages(List<ImageDTO> images) {
		this.images = images;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoBarra, id, images);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SkuDTO other = (SkuDTO) obj;
		return Objects.equals(codigoBarra, other.codigoBarra) && Objects.equals(id, other.id)
				&& Objects.equals(images, other.images);
	}

}
