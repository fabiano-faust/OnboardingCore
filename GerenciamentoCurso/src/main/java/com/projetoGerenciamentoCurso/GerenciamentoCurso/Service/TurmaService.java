package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Turma;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class TurmaService {

	
	
	private final RabbitTemplate rabbitTemplate;
	
	public void atualizaTurma(Turma turma) {
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_TURMA_ATUALIZAR, turma);
		
		
		
	}
	
	
	public void criarTurma(Turma turma) {
		
		System.out.println("enviando turma .....................");
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_TURMA_CRIAR, turma);
		
		
		
	}
	
	
	public void deletarTurma(Turma turma) {
		
		System.out.println("enviando turma .....................");
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_TURMA_DELETAR, turma);
		
		
		
	}
	
}
