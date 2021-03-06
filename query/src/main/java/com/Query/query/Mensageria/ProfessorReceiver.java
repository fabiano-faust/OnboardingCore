package com.Query.query.Mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Query.query.Model.Professor;
import com.Query.query.Repository.ProfessorRepository;

@Component
public class ProfessorReceiver {
	
	
	
	@Autowired
	public ProfessorRepository professorRepository;
	
	@RabbitListener(queues = "professorCriar")
	public void inserirProfessor(Professor professor) {
		
		System.out.println("entrou criar......................");
		professorRepository.save(professor);
		
		
	}
	
	
	@RabbitListener(queues = "professorAtualizar")
	public void atualizarProfessor(Professor professor) {

		System.out.println("entrou atualizar......................");
		
		
		
		professorRepository.save(professor);
		
		
	}
	
	@RabbitListener(queues = "professorDeletar")
	public void deletarProfessor(Professor professor) {

		System.out.println("entrou deletar......................");
		
		
		
		professorRepository.delete(professor);
		
		
	}

}
