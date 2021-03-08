package com.bruno.controleProjetos.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id; 
	private String nome;
	private String matricula;
	
	@ManyToMany(mappedBy = "alunos")
	private List<Turma>  turma = new ArrayList<>();
	
	public Aluno() {
		
	}
	
	
	public Aluno(Integer id, String nome, String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		
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
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
		
	}


	public List<Turma> getTurma() {
		return turma;
	}


	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
	

	
	

}
