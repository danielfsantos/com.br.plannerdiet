package com.br.plannerdiet.domain.dto;

import org.springframework.data.domain.Page;

import com.br.plannerdiet.domain.model.Ingredientes;

public class IngredientesModelDto {
	private String nome;
	
	private Long id;

	public IngredientesModelDto(Ingredientes ingredientes) {
		this.nome = ingredientes.getNome();
		this.id = ingredientes.getId();
	}

	public String getNome() {
		return nome;
	}
	
	public Long getId() {
		return id;
	}

	public static Page<IngredientesModelDto> converter(Page<Ingredientes> ingredientes) {
		return ingredientes.map(IngredientesModelDto::new);
	}

}
