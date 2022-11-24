package com.maker.exercicioquatro.entities;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class Image {
	 
	@Column(name = "url", length = 400)
	private String url;
	
}
