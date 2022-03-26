package com.br.plannerdiet.plannerdiet.form.atualizacao;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.br.plannerdiet.plannerdiet.model.Ingredientes;
import com.br.plannerdiet.plannerdiet.model.Receita;
import com.br.plannerdiet.plannerdiet.repository.ReceitaRepository;

public class AtualizacaoReceitaForm {
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String nome;
	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String mododepreparo;

	private List<Ingredientes> ingredientes;

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setMododepreparo(String mododepreparo) {
		this.mododepreparo = mododepreparo;
	}

	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Receita atualizarReceita(long id, ReceitaRepository receitaRepository) {
		Receita receita = receitaRepository.getOne(id);
		receita.setNome(this.nome);
		receita.setMododepreparo(this.mododepreparo);
		receita.setIngredientes(this.ingredientes);
		return receita;
	}
}
