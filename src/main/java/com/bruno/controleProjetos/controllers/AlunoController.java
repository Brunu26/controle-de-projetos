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

import com.bruno.controleProjetos.domain.Aluno;
import com.bruno.controleProjetos.services.AlunoService;
@RestController
@RequestMapping("/alunos")
public class AlunoController {

	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> get(){
		return ResponseEntity.ok(alunoService.getAlunos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> get(@PathVariable("id") Long id){
		Optional<Aluno> aluno = alunoService.getAlunoById(id);
		return aluno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());

	}
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<List<Aluno>> getAlunos(@PathVariable("matricula") String matricula){
		List<Aluno> listaAlunos = alunoService.getAlunoByMatricula(matricula);
		return listaAlunos.isEmpty() ?
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaAlunos);
	}
	@PostMapping
	public String insertAluno(@RequestBody Aluno aluno) {
		Aluno a = alunoService.insert(aluno);
		return "Aluno salvo com sucesso: " + a.getId();
	}
	@PutMapping("/{id}")
	public String updateAluno(@PathVariable("id") Long id, @RequestBody Aluno aluno) {
		Aluno a = alunoService.update(aluno, id);
		return "Aluno atualizado com sucesso: " + a.getId();
	}
	@DeleteMapping("/{id}")
	public String deleteAluno(@PathVariable("id") Long id) {
		alunoService.delete(id);
		return "Aluno removido com sucesso";
	}
}
