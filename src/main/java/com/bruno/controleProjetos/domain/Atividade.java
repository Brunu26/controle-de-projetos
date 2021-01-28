package com.bruno.controleProjetos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.bruno.controleProjetos.domain.enums.StatusAtividade;

@Entity
public class Atividade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	private Date dataDaEntrega;
	
	@ManyToMany
	@JoinTable(name = "atividades_alunos",
	joinColumns = @JoinColumn(name = "atividade_id"),
	inverseJoinColumns = @JoinColumn(name = "aluno_id"))	
	private List<Aluno> responsavelPelaEntrega;
	
	
	private StatusAtividade status;
	
	
	public Atividade() {
		
	}


	public Atividade(Integer id, String nome, String descricao, Date dataDaEntrega, 
			StatusAtividade status) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dataDaEntrega = dataDaEntrega;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public Date getDataDaEntrega() {
		return dataDaEntrega;
	}


	public void setDataDaEntrega(Date dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}


	public List<Aluno> getResponsavelPelaEntrega() {
		return responsavelPelaEntrega;
	}



	public StatusAtividade getStatus() {
		return status;
	}


	public void setStatus(StatusAtividade status) {
		this.status = status;
	}
	
	
}
