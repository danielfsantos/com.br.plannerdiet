package com.br.plannerdiet.domain.form;

import com.br.plannerdiet.domain.model.receita.Receita;
import com.br.plannerdiet.domain.model.receita.ReceitaSemanal;

import java.util.Date;
import java.util.List;

public class ReceitaSemanalForm {
    private Date dataInicio;
    private Date dataFim;
    private List<Receita> receitas;

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public ReceitaSemanal converter() {
        return new ReceitaSemanal(dataInicio,dataFim,receitas);
    }
}
