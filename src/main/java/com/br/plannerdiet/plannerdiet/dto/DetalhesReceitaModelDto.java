package com.br.plannerdiet.plannerdiet.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.br.plannerdiet.plannerdiet.model.Receita;

public class DetalhesReceitaModelDto {
	private String nome;

	private String mododepreparo;

	private Long id;

	private List<IngredientesModelDto> ingredientes;

	public DetalhesReceitaModelDto(Receita receita) {
		this.nome = receita.getNome();
		this.id = receita.getId();
		this.mododepreparo = receita.getMododepreparo();
		this.ingredientes = new ArrayList<>();
		this.ingredientes
				.addAll(receita.getIngredientes().stream().map(IngredientesModelDto::new).collect(Collectors.toList()));
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMododepreparo() {
		return mododepreparo;
	}

	public void setMododepreparo(String mododepreparo) {
		this.mododepreparo = mododepreparo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<IngredientesModelDto> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<IngredientesModelDto> ingredientes) {
		this.ingredientes = ingredientes;
	}

	
	
	
	
	
	
}
