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

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Disciplina;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.DisciplinaRepository;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.DisciplinaService;
@CrossOrigin
@RestController
@RequestMapping(path = DisciplinaController.PATH)
public class DisciplinaController {
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	public static final String PATH = "/disciplina";
	

	
	@PostMapping
	@Transactional
	public ResponseEntity<Disciplina> criaDisciplina(@RequestBody Disciplina disciplina) {
		
		disciplinaRepository.save(disciplina);
		disciplinaService.criarDisciplina(disciplina);
		
		return ResponseEntity.ok(disciplina);
		
	}
	@PutMapping
	@Transactional
	public ResponseEntity<Disciplina> atualizarDisciplina(@RequestBody Disciplina disciplina) {
		
		Disciplina disciplinaAtualiza = disciplinaRepository.getOne(disciplina.getIdDisciplina());		
		if(disciplinaAtualiza == null) {
			
			return ResponseEntity.notFound().build();
		}
		
		disciplinaAtualiza.setProfessores(disciplina.getProfessores());
		disciplinaAtualiza.setDescricao(disciplina.getDescricao());
		disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
		disciplinaAtualiza.setSigla(disciplina.getSigla());
		disciplinaAtualiza.setTurmas(disciplina.getTurmas());
		disciplinaService.atualizaDisciplina(disciplinaAtualiza);
		return ResponseEntity.ok(disciplinaAtualiza);
	}
	
	@DeleteMapping
	public  ResponseEntity<Disciplina> deletarDisciplina(@RequestBody Disciplina disciplina) {
		
		
		if(disciplina == null) {
			
			return ResponseEntity.notFound().build();
			
		}
		
		disciplinaRepository.delete(disciplina);
		disciplinaService.deletarDisciplina(disciplina);
		return ResponseEntity.ok(disciplina);
	}
}
