package com.maker.exerciciocinco.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.maker.exerciciocinco.exceptions.BadRequestException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateFields {

	private final List<String> nullFields = new ArrayList<>();

    public void add(Object valor, String nome) {
        boolean isNullOrEmpty;
        if (valor instanceof Collection<?>) {
            isNullOrEmpty = ListUtil.isNullOrEmpty((Collection<?>) valor);
        } else if (valor instanceof CharSequence) {
            isNullOrEmpty = Util.isNullOrEmpty(valor);
        } else if (valor != null && valor.getClass().isArray()) {
            isNullOrEmpty = ListUtil.isNullOrEmpty((Object[]) valor);
        } else {
            isNullOrEmpty = valor == null;
        }

        if (isNullOrEmpty) {
            nullFields.add(nome);
        }
    }
	
    public void validate() {
	  validate("Os seguintes campos são obrigatórios: ");
	}
	
	public void validate(String message) {
	  if (ListUtil.isNotNullOrNotEmpty(this.nullFields)) {
		 
		  List<String> mensagem = new ArrayList<>();
		  for(String field : this.nullFields) {
			 mensagem.add(field);
		  }
	      throw new BadRequestException(message + mensagem);
	  }
	}
	
}
