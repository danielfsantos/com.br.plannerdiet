package com.br.plannerdiet.plannerdiet.form;

import java.util.ArrayList;
import java.util.List;

import com.br.plannerdiet.plannerdiet.model.Ingredientes;
import com.br.plannerdiet.plannerdiet.model.Receita;
import com.br.plannerdiet.plannerdiet.repository.IngredientesRepository;

public class ReceitaModelForm {
	private String nome;
	private String mododepreparo;
	private List<Ingredientes> ingredientes = new ArrayList<>();

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMododepreparo() {
		return mododepreparo;
	}

	public void setMododepreparo(String mododepreparo) {
		this.mododepreparo = mododepreparo;
	}

	public List<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public String getNome() {
		return nome;
	}

	public Receita converter() {
		return new Receita(nome, mododepreparo, ingredientes);
	}

}
