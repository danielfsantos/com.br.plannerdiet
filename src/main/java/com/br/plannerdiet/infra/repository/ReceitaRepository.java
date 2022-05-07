package com.br.plannerdiet.infra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.plannerdiet.domain.model.receita.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {

	Page<Receita> findByNome(String nome, Pageable page);

}
