package com.br.plannerdiet.plannerdiet.infra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.br.plannerdiet.plannerdiet.domain.model.Ingredientes;

public interface IngredientesRepository extends JpaRepository<Ingredientes, Long>{

	Page<Ingredientes> findByNome(String nome, Pageable page);



}
