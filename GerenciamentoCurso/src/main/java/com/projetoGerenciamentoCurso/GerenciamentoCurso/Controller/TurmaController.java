package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.TurmaRepository;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.TurmaService;
@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH)
public class TurmaController {
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	private TurmaService turmaService;
	
	
	public static final String PATH = "/turma";
	

	@PostMapping
	public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
		
		turmaRepository.save(turma);
		turmaService.criarTurma(turma);
		return ResponseEntity.ok(turma);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<Turma> atualizarTurma(@RequestBody Turma turma) {
		Turma atualizaTurma = turmaRepository.getOne(turma.getIdTurma());
		
		if(atualizaTurma == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		atualizaTurma.setAlunos(turma.getAlunos());
		atualizaTurma.setAnoLetivo(turma.getAnoLetivo());
		atualizaTurma.setDescricao(turma.getDescricao());
		atualizaTurma.setNumeroVagas(turma.getNumeroVagas());
		atualizaTurma.setPeriodoLetivo(turma.getPeriodoLetivo());
		
		turmaService.atualizaTurma(atualizaTurma);
		
		return ResponseEntity.ok(atualizaTurma);
	}
	@DeleteMapping
	@Transactional
	public ResponseEntity<Turma> deletarTurma(@RequestBody Turma turma) {
		
		
		if(turma == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		System.out.println("achou turma :" + turma);
		turmaRepository.delete(turma);
		turmaService.deletarTurma(turma);
		return ResponseEntity.ok(turma);
		
	}
	
}
