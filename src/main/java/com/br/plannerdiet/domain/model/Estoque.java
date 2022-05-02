package com.br.plannerdiet.domain.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "Id", referencedColumnName = "id")
    private Ingredientes ingredienteId;

    @Column(nullable = false)
    private int quantidade;


    public Long getId() {
        return id;
    }

    public Ingredientes getIngredienteId() {
        return ingredienteId;
    }

    public int getQuantidade() {
        return quantidade;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setIngredienteId(Ingredientes ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
