package com.br.plannerdiet.plannerdiet.domain.dto;

import org.springframework.data.domain.Page;

import com.br.plannerdiet.plannerdiet.domain.model.Receita;

public class ReceitaModelDto {

	private String nome;

	private String mododepreparo;

	private Long id;

	public ReceitaModelDto(Receita receita) {
		this.nome = receita.getNome();
		this.id = receita.getId();
		this.mododepreparo = receita.getMododepreparo();
		
	}

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}

	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMododepreparo() {
		return mododepreparo;
	}

	public void setMododepreparo(String mododepreparo) {
		this.mododepreparo = mododepreparo;
	}

	public static Page<ReceitaModelDto> converter(Page<Receita> receita) {
		
		return receita.map(ReceitaModelDto::new);
	}

}
