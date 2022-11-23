package com.maker.exercicioum.entities;

import java.io.Serializable;

public class Image implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String url;

	public Image(String url) {

		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
