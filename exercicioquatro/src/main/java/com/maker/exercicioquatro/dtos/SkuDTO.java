package com.maker.exercicioquatro.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class SkuDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String codigoBarra;
	
	private List<ImageDTO> imagens;
}
