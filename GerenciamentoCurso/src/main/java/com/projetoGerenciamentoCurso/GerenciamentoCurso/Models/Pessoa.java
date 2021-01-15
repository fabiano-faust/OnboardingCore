package com.projetoGerenciamentoCurso.GerenciamentoCurso.Models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.boot.context.properties.ConstructorBinding;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor

public class Pessoa implements Serializable   {
	@Getter
	@Id 
	private Integer idPessoa;
	@Getter @Setter
	private String nome;
	@Getter @Setter
	private String cpf;
	@Getter @Setter
	private String email;
	

	
	

	
}
