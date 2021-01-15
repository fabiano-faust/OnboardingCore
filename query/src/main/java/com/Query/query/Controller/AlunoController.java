package com.Query.query.Controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Query.query.Model.Aluno;
import com.Query.query.Repository.AlunoRepository;

@RestController
@RequestMapping(path = AlunoController.PATH)
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	public static final String PATH = "/aluno";

	@GetMapping("/{id}")
	public ResponseEntity<List<Aluno>> retornaAluno(@PathVariable(name = "id") Integer matricula) {

		Aluno pessoaAluno = alunoRepository.getOne(matricula);

		return ResponseEntity.ok(Arrays.asList(pessoaAluno));
	}

	@GetMapping
	public ResponseEntity<List<Aluno>> retornaAluno() {

		List<Aluno> alunos = alunoRepository.findAll();

		return ResponseEntity.ok(alunos);

	}

}
