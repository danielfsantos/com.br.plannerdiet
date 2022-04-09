package com.br.plannerdiet.plannerdiet.application.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.plannerdiet.plannerdiet.domain.dto.IngredientesModelDto;
import com.br.plannerdiet.plannerdiet.domain.form.IngredientesModelForm;
import com.br.plannerdiet.plannerdiet.domain.model.Ingredientes;
import com.br.plannerdiet.plannerdiet.infra.repository.IngredientesRepository;

@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredientesRepository ingredientesRepository;

	@PostMapping
	@Transactional
	public ResponseEntity<IngredientesModelDto> salvar(@RequestBody IngredientesModelForm ingredientesForm,
			UriComponentsBuilder uriBuilder) {
		Ingredientes ingredientes = ingredientesForm.converter();
		ingredientesRepository.save(ingredientes);
		URI uri = uriBuilder.path("/ingredientes/${id}").buildAndExpand(ingredientes.getId()).toUri();
		return ResponseEntity.created(uri).body(new IngredientesModelDto(ingredientes));
	}

	@GetMapping
	public Page<IngredientesModelDto> listar(@RequestParam(required = false) String nome,
			@PageableDefault(direction = Direction.ASC, size = 10, page = 0) Pageable page) {
		if (nome == null) {
			Page<Ingredientes> ingredientes = ingredientesRepository.findAll(page);
			return IngredientesModelDto.converter(ingredientes);
		}
		Page<Ingredientes> ingredientes = ingredientesRepository.findByNome(nome, page);
		return IngredientesModelDto.converter(ingredientes);
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		Optional<Ingredientes> ingredientes = ingredientesRepository.findById(id);
		if (ingredientes.isPresent()) {
			ingredientesRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
