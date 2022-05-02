package com.br.plannerdiet.domain.form;

import com.br.plannerdiet.domain.model.Ingredientes;
import com.br.plannerdiet.infra.repository.IngredientesRepository;

public class IngredientesModelForm {

	private String nome;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ingredientes converter() {
		return new Ingredientes(nome);
	}

	public Ingredientes atualizar(Long id, IngredientesRepository repository) {
		Ingredientes ing = repository.getOne(id);
		ing.setNome(this.nome);
		return ing;
	}

}
