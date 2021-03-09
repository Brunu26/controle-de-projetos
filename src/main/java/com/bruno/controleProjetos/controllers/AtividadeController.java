package com.bruno.controleProjetos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bruno.controleProjetos.domain.Atividade;
import com.bruno.controleProjetos.services.AtividadeService;

@RestController
@RequestMapping("/atividades")
public class AtividadeController {

	@Autowired
	private AtividadeService atividadeService;
	
	@GetMapping
	public ResponseEntity<List<Atividade>> get(){
		return ResponseEntity.ok(atividadeService.getAtividades());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atividade> get(@PathVariable("id") Long id){
		Optional<Atividade> atividade = atividadeService.getAtividadeById(id);
		return atividade.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	@PostMapping
	public String InsertAtividade(@RequestBody Atividade atividade) {
		Atividade a = atividadeService.insert(atividade);
		return "Atividade salva com sucesso: " + a.getId();
	}
	
	@PutMapping("/{id}")
	public String updateAtividade(@PathVariable("id") Long id, @RequestBody Atividade atividade) {
		Atividade a = atividadeService.update(atividade, id);
		return "Atividade Atualizada com sucesso: " + a.getId();
	}
	
	@DeleteMapping("/{id}")
	public String deleteAtividade(@PathVariable("id") Long id) {
		atividadeService.delete(id);
		return "Atividade removida com sucesso.";
	}
}
