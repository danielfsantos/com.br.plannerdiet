package com.br.plannerdiet.infra.repository;

import com.br.plannerdiet.domain.model.receita.ReceitaSemanal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceitaSemanalRepository extends JpaRepository<ReceitaSemanal, Long> {
}
