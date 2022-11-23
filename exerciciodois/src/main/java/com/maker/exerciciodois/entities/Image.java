package com.maker.exerciciodois.entities;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Image implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String url;
}
