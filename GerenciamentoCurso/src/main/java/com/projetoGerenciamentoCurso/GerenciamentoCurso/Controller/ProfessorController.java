package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Professor;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.ProfessorRepository;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.ProfessorService;
@RestController
@RequestMapping(path = ProfessorController.PATH)
public class ProfessorController {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private ProfessorService professorService;
	
	public static final String PATH = "/professor";
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<Professor> salvaProfessor(@RequestBody Professor professor) {
		
		professorRepository.save(professor);
		professorService.criarProfessor(professor);
		return ResponseEntity.ok(professor);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Professor> atualizaProfessor(@RequestBody Professor professor) {
		Professor atualizaProfessor = professorRepository.getOne(professor.getIdPessoa());
		if(atualizaProfessor == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		System.out.println(atualizaProfessor);
		atualizaProfessor.setCpf(professor.getCpf());
		atualizaProfessor.setEmail(professor.getEmail());
		atualizaProfessor.setNome(professor.getNome());
		atualizaProfessor.setTitulacao(professor.getTitulacao());
		
		professorService.atualizaProfessor(atualizaProfessor);
		
		
		return ResponseEntity.ok(atualizaProfessor);
		
	}
	
	@DeleteMapping
	@Transactional
	public ResponseEntity<Professor> deletarProfessor(@RequestBody Professor professor) {
		
		
		professorRepository.delete(professor);
		
		professorService.deletarProfessor(professor);
		
		return ResponseEntity.ok(professor);
	}
}
