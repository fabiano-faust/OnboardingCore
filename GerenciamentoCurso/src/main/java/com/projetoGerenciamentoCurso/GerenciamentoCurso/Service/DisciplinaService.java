package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projetoGerenciamentoCurso.GerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Disciplina;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Professor;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DisciplinaService {

	
	@Autowired
	private final RabbitTemplate rabbitTemplate;
	
	public void atualizaDisciplina(Disciplina disciplina) {
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_DISCIPLINA_ATUALIZAR, disciplina);
		
		
		
	}
	
	
	public void criarDisciplina(Disciplina disciplina) {
		
		System.out.println("enviando professor .....................");
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_DISCIPLINA_CRIAR, disciplina);
		
		
		
	}
	
	
	public void deletarDisciplina(Disciplina disciplina) {
		
		System.out.println("enviando turma .....................");
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_DISCIPLINA_DELETAR, disciplina);
		
		
		
	}
	
}
