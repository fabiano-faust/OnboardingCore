package com.projetoGerenciamentoCurso.GerenciamentoCurso.Controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Aluno;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.AlunoRepository;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Repository.PessoaRepository;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Service.AlunoService;

@RestController
@RequestMapping(path = AlunoController.PATH)
public class AlunoController {

	@Autowired
	private AlunoRepository alunoRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public static final String PATH = "/aluno";

	@Autowired
	private AlunoService alunoService;

	@PostMapping
	@Transactional
	public ResponseEntity<Aluno> salvarAluno(@RequestBody Aluno aluno) {
		
		if(aluno instanceof Aluno) {
			
			alunoRepository.save(aluno);
			alunoService.retornaAluno(aluno);
		}
		else {
			
			ResponseEntity.badRequest();
		}
		
		
	
		
		
		
		
		return ResponseEntity.ok(aluno);
	}

	@PutMapping
	@Transactional
	public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno atualizaAluno) {
		Aluno aluno = alunoRepository.findByMatricula(atualizaAluno.getMatricula());
		if (aluno != null) {

			aluno.setCpf(atualizaAluno.getCpf());
			aluno.setEmail(atualizaAluno.getEmail());
			aluno.setFormaIngresso(atualizaAluno.getFormaIngresso());
			aluno.setNome(atualizaAluno.getNome());
			aluno.setTurma(atualizaAluno.getTurma());
			alunoService.atualizarAluno(aluno);
		} else {
			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(aluno);

	}

	@DeleteMapping
	public ResponseEntity<Aluno> deletarAluno(@RequestBody Aluno deletaAluno) {

		
		if (deletaAluno != null) {
			
			
			alunoRepository.delete(deletaAluno);
			alunoService.deletarAluno(deletaAluno);
			
		} else {

			return ResponseEntity.notFound().build();

		}

		return ResponseEntity.ok(deletaAluno);
	}

}
