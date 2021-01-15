package com.Query.query.Model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Aluno extends Pessoa implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter @Setter
	private Integer matricula;
	@Getter @Setter
	@NotNull
	private String formaIngresso;
	@Getter @Setter
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<Turma> turma = new HashSet<Turma>();
	
	public Aluno(Integer idPessoa, String nome, String cpf, String email, Integer matricula, String formaIngresso,
			Set<Turma> turma) {
		super(idPessoa, nome, cpf, email);
		this.matricula = super.getIdPessoa();
		this.formaIngresso = formaIngresso;
		this.turma = turma;
	}
	
	

	
	

	

	
	

	
	

	
	
	
	
	
}
