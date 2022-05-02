package com.br.plannerdiet.domain.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false,length = 500)
	@Size(max = 1337)
	private String mododepreparo;

	@OneToMany
	private List<Ingredientes> ingredientes;

	public Receita() {

	}

	public Receita(String nome, String mododepreparo, List<Ingredientes> ingredientes) {
		this.nome = nome;
		this.mododepreparo = mododepreparo;
		this.ingredientes = ingredientes;
	}

	public String getMododepreparo() {
		return mododepreparo;
	}

	public void setMododepreparo(String mododepreparo) {
		this.mododepreparo = mododepreparo;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Ingredientes> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(List<Ingredientes> ingredientes) {
		this.ingredientes = ingredientes;
	}

}
