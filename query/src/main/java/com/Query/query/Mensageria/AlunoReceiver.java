package com.Query.query.Mensageria;

import java.awt.Menu;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Query.query.Model.Aluno;
import com.Query.query.Repository.AlunoRepository;

@Component
public class AlunoReceiver {

	@Autowired
	AlunoRepository alunoRepository;

	@RabbitListener(queues = { "alunoCriar" })
	public void criarAluno(Aluno aluno) {

		System.out.println("deu certooo ...............");

		System.out.println(aluno);

		alunoRepository.save(aluno);

	}

	@RabbitListener(queues = { "alunoAtualizar" })
	public void atualizarAluno(Aluno atualizaAluno) {

		Aluno aluno = alunoRepository.getOne(atualizaAluno.getIdPessoa());
		
		if (aluno != null) {
			
			aluno.setCpf(atualizaAluno.getCpf());
			aluno.setEmail(atualizaAluno.getEmail());
			aluno.setFormaIngresso(atualizaAluno.getFormaIngresso());
			aluno.setNome(atualizaAluno.getNome());
			aluno.setTurma(atualizaAluno.getTurma());
			
		} else {
			System.out.println("aluno não encontrado"); 
		}
		
		
		
		System.out.println(aluno);

		alunoRepository.save(aluno);

	}
	
	@RabbitListener(queues = { "alunoDeletar" })
	public void deletarAluno(Aluno aluno) {

		System.out.println("deu certooo ...............");

		System.out.println(aluno);
		Aluno alunoAchado = alunoRepository.getOne(aluno.getIdPessoa());
		System.out.println("achoouuuuuuuuuu............." + aluno.getEmail());
		alunoRepository.delete(aluno);

	}
	
}
