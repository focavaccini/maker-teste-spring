package com.maker.exercicioum.dtos;

import java.io.Serializable;

public class ImageDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	private String url;

	public ImageDTO(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
