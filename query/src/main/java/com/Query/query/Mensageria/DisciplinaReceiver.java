package com.Query.query.Mensageria;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Query.query.Model.Disciplina;
import com.Query.query.Model.Turma;
import com.Query.query.Repository.DisciplinaRepository;
import com.Query.query.Repository.TurmaRepository;

@Component
public class DisciplinaReceiver {
	
	@Autowired
	public DisciplinaRepository disciplinaRepository;
	
	@RabbitListener(queues = "disciplinaCriar")
	public void inserirTurma(Disciplina disciplina) {
		
		System.out.println("entrou ......................");
		disciplinaRepository.save(disciplina);
		
		
	}
	
	
	@RabbitListener(queues = "disciplinaAtualizar")
	public void atualizarTurma(Disciplina disciplina) {

		System.out.println("entrou atualizar......................");
		
				Disciplina disciplinaAtualiza = disciplinaRepository.getOne(disciplina.getIdDisciplina());
		///		disciplinaAtualiza.setProfessoeres(disciplina.getProfessoeres());
				disciplinaAtualiza.setDescricao(disciplina.getDescricao());
				disciplinaAtualiza.setCargaHoraria(disciplina.getCargaHoraria());
				disciplinaAtualiza.setSigla(disciplina.getSigla());
				disciplinaAtualiza.setTurmas(disciplina.getTurmas());
				
		
		disciplinaRepository.save(disciplina);
		
		
	}
	
	@RabbitListener(queues = "disciplinaDeletar")
	public void deletarTurma(Disciplina disciplina) {

		System.out.println("entrou atualizar......................");
		
		
		
		disciplinaRepository.delete(disciplina);
		
		
	}
	

}
