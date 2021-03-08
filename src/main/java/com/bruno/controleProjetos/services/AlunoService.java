package com.bruno.controleProjetos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.controleProjetos.domain.Aluno;
import com.bruno.controleProjetos.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepo;
	
	public List<Aluno> getAlunos(){
		return alunoRepo.findAll();
	}
	
	public Optional<Aluno> getAlunoById(Long id){
		return alunoRepo.findById(id);
		
	}
	
	public List<Aluno> getAlunoByMatricula(String matricula){
		return alunoRepo.findByMatricula(matricula);
	}
	
	public Aluno insert(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	public Aluno update(Aluno aluno, Long id) {
		Optional<Aluno> optional = getAlunoById(id);
		if(optional.isPresent()) {
			Aluno alunoBD = optional.get();
			alunoBD.setNome(aluno.getNome());
			alunoBD.setMatricula(aluno.getMatricula());
			alunoBD.setTurma(aluno.getTurma());
			
			alunoRepo.save(alunoBD);
			return alunoBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar o aluno informado");
		}
	}
	
	public void delete(Long id) {
		Optional<Aluno> aluno = getAlunoById(id);
		if(aluno.isPresent()) {
			alunoRepo.deleteById(id);
		}
	}
}
