package com.Query.query.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Query.query.Model.Turma;
import com.Query.query.Repository.TurmaRepository;

@CrossOrigin
@RestController
@RequestMapping(path = TurmaController.PATH)
public class TurmaController {

	@Autowired
	private TurmaRepository turmaRepository;

	public static final String PATH = "/turma";

	@GetMapping("/{id}")
	public ResponseEntity<Turma> retornaTurma(@PathVariable Integer id) {

		Turma turma = turmaRepository.getOne(id);

		return ResponseEntity.ok(turma);
	}
	
	
	
	@GetMapping
	public  ResponseEntity<List<Turma>> retornaTurma() {

		List<Turma> turmas = turmaRepository.findAll();

		return ResponseEntity.ok(turmas);
	}

}
