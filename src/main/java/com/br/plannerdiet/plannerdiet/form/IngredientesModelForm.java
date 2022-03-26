package com.br.plannerdiet.plannerdiet.form;

import com.br.plannerdiet.plannerdiet.model.Ingredientes;

public class IngredientesModelForm {
			
	
	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ingredientes converter() {
		
		return new Ingredientes(nome);
	}
	
	
	
	
}
