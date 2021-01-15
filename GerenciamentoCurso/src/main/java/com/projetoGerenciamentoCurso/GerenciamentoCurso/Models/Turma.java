package com.projetoGerenciamentoCurso.GerenciamentoCurso.Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class Turma {
	@Id
	@Getter 
	private Integer idTurma;
	@Getter @Setter
	private String anoLetivo;
	@Getter @Setter
	private String descricao;
	@Setter @Getter
	private Integer numeroVagas;
	@Getter @Setter
	private Integer periodoLetivo;
	@Getter @Setter
	@OneToMany(mappedBy = "turmas",orphanRemoval = true , cascade = CascadeType.PERSIST)
	@JsonManagedReference
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Disciplina> disciplinas = new HashSet<Disciplina>();
	@Getter @Setter
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "turma")
	@JsonIgnore
	private Set<Aluno> alunos = new HashSet<Aluno>();


//	
//	
//	private void adicionarAlunos(Aluno aluno) {
//		
//		if(getAlunos().size()<numeroVagas) {
//			getAlunos().add(aluno);
//			
//		}
		
		
//	}
	public void settarNull() {
		
		this.disciplinas = new HashSet<Disciplina>();
		
		
	}
	
}
