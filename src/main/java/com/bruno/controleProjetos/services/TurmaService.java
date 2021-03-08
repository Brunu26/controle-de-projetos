package com.bruno.controleProjetos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.controleProjetos.domain.Turma;
import com.bruno.controleProjetos.repositories.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepo;
	
	public List<Turma> getTurmas(){
		return turmaRepo.findAll();
	}
	
	public Optional<Turma> getTurmaById(Long id){
		return turmaRepo.findById(id);
	}
	
	public Turma insert(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	public Turma update(Turma turma, Long id) {
		Optional<Turma> optional = getTurmaById(id);
		
		if(optional.isPresent()) {
			Turma turmaBD = optional.get();
			turmaBD.setNome(turma.getNome());
			
			turmaRepo.save(turmaBD);
			return turmaBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar a turma informada");
		}
	}
	
	public void delete(Long id) {
		Optional<Turma> turma = getTurmaById(id);
		if(turma.isPresent()) {
			turmaRepo.deleteById(id);
		}
	}
}
