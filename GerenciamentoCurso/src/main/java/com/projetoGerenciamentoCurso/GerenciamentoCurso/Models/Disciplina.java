package com.projetoGerenciamentoCurso.GerenciamentoCurso.Models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Disciplina implements Serializable{
	
	
	@Id 
	@Getter 
	private Integer idDisciplina;
	@Getter @Setter
	private String descricao;
	@Getter @Setter
	private String cargaHoraria;
	@Getter @Setter
	private String sigla;
	@Getter @Setter
	@ManyToOne
	@JsonBackReference
	private Turma turmas;

	@Getter @Setter
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "disciplina")
	private Set<Professor> professores = new HashSet<Professor>(); 
	

}
