package com.projetoGerenciamentoCurso.GerenciamentoCurso;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;

import javassist.bytecode.ByteArray;

@SpringBootApplication

public class GerenciamentoCursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentoCursoApplication.class, args);
	}

	public static final String EXCHANGE_NAME = "amq.direct";
	public static final String QUEUE_GENERIC_NAME = "alunoCriar";
	public static final String QUEUE_SPECIFIC_NAME = "alunoAtualizar";
	public static final String QUEUE_ALUNO_DELETAR = "alunoDeletar";

	public static final String QUEUE_TURMA_ATUALIZAR = "turmaAtualizar";
	public static final String QUEUE_TURMA_CRIAR = "turmaCriar";
	public static final String QUEUE_TURMA_DELETAR = "turmaCriar";
	
	public static final String QUEUE_PROFESSOR_ATUALIZAR = "professorAtualizar";
	public static final String QUEUE_PROFESSOR_CRIAR = "professorCriar";
	public static final String QUEUE_PROFESSOR_DELETAR = "professorDeletar";
	
	public static final String QUEUE_DISCIPLINA_ATUALIZAR = "disciplinaAtualizar";
	public static final String QUEUE_DISCIPLINACRIAR = "disciplinaCriar";
	public static final String QUEUE_DISCIPLINA_DELETAR = "disciplinaDeletar";
	
	
	public static final String ROUTING_KEY = "route";
	public static final String ROUTING_KEY_ALUNO = "route_aluno_atualizar";
	public static final String ROUTING_KEY_ALUNO_DELETAR = "route_aluno_deletar";

	public static final String ROUTING_TURMA_ATUALIZAR = "turma_atualizar";
	public static final String ROUTING_TURMA_CRIAR = "turma_criar";
	public static final String ROUTING_TURMA_DELETAR = "turma_deletar";
	
	public static final String ROUTING_DISCIPLINA_ATUALIZAR = "disciplina_atualizar";
	public static final String ROUTING_DISCIPLINA_CRIAR = "disciplina_criar";
	public static final String ROUTING_DISCIPLINA_DELETAR = "disciplina_deletar";
	
	public static final String ROUTING_PROFESSOR_ATUALIZAR = "professor_atualizar";
	public static final String ROUTING_PROFESSOR_CRIAR = "professor_criar";
	public static final String ROUTING_PROFESSOR_DELETAR = "professor_deletar";
	

	@Bean
	public DirectExchange appExchange() {
		return new DirectExchange(EXCHANGE_NAME);
	}

	@Bean
	public Queue appQueueGeneric() {
		return new Queue(QUEUE_GENERIC_NAME);
	}

	@Bean
	public Queue appQueueAluno() {
		return new Queue(QUEUE_SPECIFIC_NAME);
	}

	@Bean
	public Queue appQueueAlunoDel() {
		return new Queue(QUEUE_ALUNO_DELETAR);
	}

	@Bean
	public Queue appQueueTurmaAtualizar() {
		return new Queue(QUEUE_TURMA_ATUALIZAR);
	}

	@Bean
	public Queue appQueueTurmaCriar() {
		return new Queue(QUEUE_TURMA_CRIAR);
	}
	
	@Bean
	public Queue appQueueTurmaDeletar() {
		return new Queue(QUEUE_TURMA_DELETAR);
	}
	
	@Bean
	public Queue appQueueProfessorDeletar() {
		return new Queue(QUEUE_PROFESSOR_DELETAR);
	}
	
	@Bean
	public Queue appQueueProfessorAtualizar() {
		return new Queue(QUEUE_PROFESSOR_ATUALIZAR);
	}
	
	@Bean
	public Queue appQueueProfessorCriar() {
		return new Queue(QUEUE_PROFESSOR_CRIAR);
	}
	
	@Bean
	public Binding declareBindingGeneric() {
		return BindingBuilder.bind(appQueueGeneric()).to(appExchange()).with(ROUTING_KEY);
	}

	@Bean
	public Binding declareBindingSpecific() {
		return BindingBuilder.bind(appQueueAluno()).to(appExchange()).with(ROUTING_KEY_ALUNO);
	}

	@Bean
	public Binding declareBindindeletarALuno() {
		return BindingBuilder.bind(appQueueAlunoDel()).to(appExchange()).with(ROUTING_KEY_ALUNO_DELETAR);
	}

	@Bean
	public Binding declareBindingAtulizarTurma() {
		return BindingBuilder.bind(appQueueTurmaAtualizar()).to(appExchange()).with(ROUTING_TURMA_ATUALIZAR);
	}

	@Bean
	public Binding declareBindingCriarTurma() {
		return BindingBuilder.bind(appQueueProfessorCriar()).to(appExchange()).with(QUEUE_PROFESSOR_CRIAR);
	}
	
	@Bean
	public Binding declareBindingProfessorDeletar() {
		return BindingBuilder.bind(appQueueProfessorDeletar()).to(appExchange()).with(QUEUE_PROFESSOR_DELETAR);
	}
	
	@Bean
	public Binding declareBindingCriarProfessor() {
		return BindingBuilder.bind(appQueueProfessorCriar()).to(appExchange()).with(ROUTING_PROFESSOR_CRIAR);
	}
	
	@Bean
	public Binding declareBindingProfessorAtualizar() {
		return BindingBuilder.bind(appQueueProfessorAtualizar()).to(appExchange()).with(ROUTING_PROFESSOR_ATUALIZAR);
	}
	
	@Bean
	public Binding declareBindingDeletarTurma() {
		return BindingBuilder.bind(appQueueTurmaDeletar()).to(appExchange()).with(ROUTING_TURMA_DELETAR);
	}
	
//	   
//	    @Bean
//	    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//	        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
//	        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
//	        messageConverters.add(new FormHttpMessageConverter());
//	        messageConverters.add(new StringHttpMessageConverter());
//	 
//	        rabbitTemplate.setMessageConverter((MessageConverter) new StringHttpMessageConverter());
//	        return rabbitTemplate;
//	    }

//	    @Bean
//	    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
//	        return new Jackson2JsonMessageConverter();
//	    }

}