package com.br.plannerdiet.plannerdiet.controller;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.plannerdiet.plannerdiet.dto.DetalhesReceitaModelDto;
import com.br.plannerdiet.plannerdiet.dto.ReceitaModelDto;
import com.br.plannerdiet.plannerdiet.dto.ReceitasSemanaisDto;
import com.br.plannerdiet.plannerdiet.form.ReceitaModelForm;
import com.br.plannerdiet.plannerdiet.form.atualizacao.AtualizacaoReceitaForm;
import com.br.plannerdiet.plannerdiet.model.Receita;
import com.br.plannerdiet.plannerdiet.repository.ReceitaRepository;

@RestController
@RequestMapping("/receita")
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;

	@PostMapping
	public ResponseEntity<ReceitaModelDto> salvar(@RequestBody ReceitaModelForm receitaForm,
			UriComponentsBuilder uriBuilder) {
		Receita receita = receitaForm.converter();
		receitaRepository.save(receita);
		URI uri = uriBuilder.path("/receita/{id}").buildAndExpand(receita.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaModelDto(receita));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesReceitaModelDto> detalharReceita(@PathVariable Long id) {
		Optional<Receita> receita = receitaRepository.findById(id);
		if (receita.isPresent()) {
			return ResponseEntity.ok(new DetalhesReceitaModelDto(receita.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping
	public Page<ReceitaModelDto> listaReceita(@RequestParam(required = false) String nome,
			@PageableDefault(direction = Direction.ASC, size = 10, page = 0) Pageable page) {
		if (nome == null) {
			Page<Receita> receita = receitaRepository.findAll(page);
			return ReceitaModelDto.converter(receita);
		}

		Page<Receita> receita = receitaRepository.findByNome(nome, page);
		return ReceitaModelDto.converter(receita);

	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ReceitaModelDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoReceitaForm form) {
		Optional<Receita> opt = receitaRepository.findById(id);
		if (opt.isPresent()) {
			Receita receita = form.atualizarReceita(id, receitaRepository);
			return ResponseEntity.ok(new ReceitaModelDto(receita));
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/semanal")
	public ResponseEntity<ReceitasSemanaisDto> listaDeReceitas(@RequestBody ReceitasSemanaisDto receitasSemanais) {
		return null;

	}

}
