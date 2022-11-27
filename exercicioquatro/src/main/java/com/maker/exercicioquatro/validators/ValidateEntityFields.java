package com.maker.exercicioquatro.validators;

import com.maker.exercicioquatro.entities.Product;
import com.maker.exercicioquatro.utils.ValidateFields;

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
