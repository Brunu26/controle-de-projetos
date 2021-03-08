package com.bruno.controleProjetos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bruno.controleProjetos.domain.Atividade;
import com.bruno.controleProjetos.repositories.AtividadeRepository;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepo;
	
	public List<Atividade> getAtividades(){
		return atividadeRepo.findAll();
	}
	
	public Optional<Atividade> getAtividadeById(Long id){
		return atividadeRepo.findById(id);
		
	}
		
	
	public Atividade insert(Atividade atividade) {
		return atividadeRepo.save(atividade);
	}
	
	public Atividade update(Atividade atividade, Long id) {
		Optional<Atividade> optional = getAtividadeById(id);
		if(optional.isPresent()) {
			Atividade atividadeBD = optional.get();
			atividadeBD.setNome(atividade.getNome());
			atividadeBD.setDescricao(atividade.getDescricao());
			atividadeBD.setDataDaEntrega(atividade.getDataDaEntrega());
			
			atividadeRepo.save(atividadeBD);
			return atividadeBD;
		}
		else {
			throw new RuntimeException("Não foi possível atualizar a atividade informada");
		}
	}
	
	public void delete(Long id) {
		Optional<Atividade> atividade = getAtividadeById(id);
		if(atividade.isPresent()) {
			atividadeRepo.deleteById(id);
		}
	}
}
