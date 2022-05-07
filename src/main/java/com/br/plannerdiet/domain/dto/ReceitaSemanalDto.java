package com.br.plannerdiet.domain.dto;

import java.util.Date;
import java.util.List;

import com.br.plannerdiet.domain.model.receita.Receita;
import com.br.plannerdiet.domain.model.receita.ReceitaSemanal;
import org.springframework.data.domain.Page;

public class ReceitaSemanalDto {

	private Date dataInicio;
	private Date dataFim;
	private List<Receita> receitas;

	public ReceitaSemanalDto(ReceitaSemanal receitaSemanal) {
		this.dataInicio = receitaSemanal.getDataInicio();
		this.dataFim = receitaSemanal.getDataFim();
		this.receitas = receitaSemanal.getReceitas();
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public List<Receita> getReceitas() {
		return receitas;
	}

	public void setReceitas(List<Receita> receitas) {
		this.receitas = receitas;
	}

	public static Page<ReceitaSemanalDto> converter(Page<ReceitaSemanal> receitaSemanal) {
		return receitaSemanal.map(ReceitaSemanalDto::new);
	}
}
