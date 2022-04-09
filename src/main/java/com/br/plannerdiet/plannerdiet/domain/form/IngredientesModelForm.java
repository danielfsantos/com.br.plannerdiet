package com.br.plannerdiet.plannerdiet.domain.form;

import com.br.plannerdiet.plannerdiet.domain.model.Ingredientes;

public class IngredientesModelForm {
			
	
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ingredientes converter() {
		
		return new Ingredientes(nome);
	}
	
	
	
	
}
