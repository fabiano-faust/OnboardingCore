package com.projetoGerenciamentoCurso.GerenciamentoCurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.TurmaRepository;

@RestController
@RequestMapping("/")
public class Teste {
	 
	@Autowired
	private TurmaRepository turmarepository;
	
	
	@GetMapping
	public List<Turma> teste() {
		List<Turma> turma = turmarepository.findAll();
		
		return turma;
		
	}
	

}
