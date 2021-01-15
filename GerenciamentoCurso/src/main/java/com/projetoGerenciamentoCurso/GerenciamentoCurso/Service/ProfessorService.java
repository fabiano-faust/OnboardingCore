package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Professor;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {

	private final RabbitTemplate rabbitTemplate;
	
	public void atualizaProfessor(Professor professor) {
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_PROFESSOR_ATUALIZAR, professor);
		
		
		
	}
	
	
	public void criarProfessor(Professor professor) {
		
		System.out.println("enviando professor .....................");
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_PROFESSOR_CRIAR, professor);
		
		
		
	}
	
	
	public void deletarProfessor(Professor professor) {
		
		System.out.println("enviando turma .....................");
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_PROFESSOR_DELETAR, professor);
		
		
		
	}
	
}
