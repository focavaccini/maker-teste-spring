package com.maker.exerciciodois.dtos;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ImageDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String url;
	
}
