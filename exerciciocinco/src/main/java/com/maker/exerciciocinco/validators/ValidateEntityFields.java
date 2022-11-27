package com.maker.exerciciocinco.validators;

import com.maker.exerciciocinco.entities.Product;
import com.maker.exerciciocinco.utils.ValidateFields;

public class ValidateEntityFields {
	
	private void validateMandatoryFields(Product product) {
		ValidateFields validate = new ValidateFields();
		validate.add(product.getDepartamento(), "Departamento");
		validate.add(product.getDescricao(), "Descrição");
		validate.add(product.getMarca(), "Marca");
		validate.add(product.getQuantidadeEstoque(), "Quantidade estoque");
		validate.add(product.getSkus(), "Skus");
		validate.add(product.getImagens(), "Imagens");
		
		validate.validate();
	}
	
	
	public void ValidateEntity(Product product) {
		validateMandatoryFields(product);
	}
}
