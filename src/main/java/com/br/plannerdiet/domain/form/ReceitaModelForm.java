package com.br.plannerdiet.domain.form;

import java.util.ArrayList;
import java.util.List;

import com.br.plannerdiet.domain.model.Ingredientes;
import com.br.plannerdiet.domain.model.receita.Receita;

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
