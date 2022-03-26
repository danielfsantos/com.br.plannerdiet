package com.br.plannerdiet.plannerdiet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ingredientes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Column(nullable = false)
	private String nome;

		
	public Ingredientes(String nome,Long id) {
		this.nome = nome;
		this.Id = id;
	}
	
	
	public 	Ingredientes(String nome) {
		this.nome = nome;
	}
	
	public Ingredientes() {
		
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


}
