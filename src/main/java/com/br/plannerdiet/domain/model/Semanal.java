package com.br.plannerdiet.domain.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Semanal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    @OneToMany
    private List<Receita> receitas;


    public Long getId() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }


    public void setId(Long id) {
        this.id = id;
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
}
