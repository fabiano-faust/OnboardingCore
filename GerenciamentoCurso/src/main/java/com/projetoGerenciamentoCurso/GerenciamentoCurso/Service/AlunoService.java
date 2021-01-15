package com.projetoGerenciamentoCurso.GerenciamentoCurso.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.GerenciamentoCursoApplication;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Mensageria.CustomMessage;
import com.projetoGerenciamentoCurso.GerenciamentoCurso.Models.Aluno;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class AlunoService {

	

	private final RabbitTemplate rabbitTemplate;



	public void retornaAluno(Aluno aluno) {
		
		System.out.println("enviando aluno................");
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME,GerenciamentoCursoApplication.ROUTING_KEY,aluno);

	}
	
	
	
	public void deletarAluno(Aluno aluno) {
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_KEY_ALUNO_DELETAR, aluno);
	}
	
	
	public void atualizarAluno(Aluno aluno) {
		
		rabbitTemplate.convertAndSend(GerenciamentoCursoApplication.EXCHANGE_NAME, GerenciamentoCursoApplication.ROUTING_KEY_ALUNO, aluno);
	}
	
}
