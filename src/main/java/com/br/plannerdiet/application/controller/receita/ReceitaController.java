package com.br.plannerdiet.application.controller.receita;

import java.net.URI;

import java.util.Optional;

import javax.transaction.Transactional;

import com.br.plannerdiet.domain.form.ReceitaSemanalForm;
import com.br.plannerdiet.domain.model.receita.ReceitaSemanal;
import com.br.plannerdiet.infra.repository.ReceitaSemanalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.plannerdiet.domain.dto.DetalhesReceitaModelDto;
import com.br.plannerdiet.domain.dto.ReceitaModelDto;
import com.br.plannerdiet.domain.dto.ReceitaSemanalDto;
import com.br.plannerdiet.domain.form.ReceitaModelForm;
import com.br.plannerdiet.domain.form.atualizacao.AtualizacaoReceitaForm;
import com.br.plannerdiet.domain.model.receita.Receita;
import com.br.plannerdiet.infra.repository.ReceitaRepository;



/***
 * 
 * @author Daniel
 *
 */

@RestController
@RequestMapping("/receita")
public class ReceitaController {

	@Autowired
	private ReceitaRepository receitaRepository;

	@Autowired
	private ReceitaSemanalRepository receitaSemanalRepository;

	@PostMapping
	public ResponseEntity<ReceitaModelDto> salvar(@RequestBody ReceitaModelForm receitaForm,UriComponentsBuilder uriBuilder) {
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
	public Page<ReceitaSemanalDto> listaDeReceitassemanais(@PageableDefault(direction = Direction.ASC, size = 10, page = 0) Pageable page) {
			Page<ReceitaSemanal> receitaSemanal = receitaSemanalRepository.findAll(page);
			return ReceitaSemanalDto.converter(receitaSemanal);
	}


	@PostMapping("/salvar-semanal")
	public ResponseEntity<ReceitaSemanalDto> salvarSemanal(@RequestBody ReceitaSemanalForm receitaSemanalForm, UriComponentsBuilder uriBuilder){
		ReceitaSemanal receitasSemanais = receitaSemanalForm.converter();
		receitaSemanalRepository.save(receitasSemanais);
		URI uri = uriBuilder.path("/receita/salvar-semanal/{id}").buildAndExpand(receitasSemanais.getId()).toUri();
		return ResponseEntity.created(uri).body(new ReceitaSemanalDto(receitasSemanais));

	}

}
