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

import com.bruno.controleProjetos.domain.Turma;
import com.bruno.controleProjetos.services.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@GetMapping
	public ResponseEntity<List<Turma>> get(){
		return ResponseEntity.ok(turmaService.getTurmas());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> get(@PathVariable("id") Long id){
		Optional<Turma> turma = turmaService.getTurmaById(id);
		return turma.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	@PostMapping
	public String InsertTurma(@RequestBody Turma turma) {
		Turma t = turmaService.insert(turma);
		return "Turma salva com sucesso: " + t.getId();
	}
	
	@PutMapping("/{id}")
	public String updateTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
		Turma t = turmaService.update(turma, id);
		return "Turma Atualizada com sucesso: " + t.getId();
	}
	
	@DeleteMapping("/{id}")
	public String deleteTurma(@PathVariable("id") Long id) {
		turmaService.delete(id);
		return "Turma removida com sucesso.";
	}
}
