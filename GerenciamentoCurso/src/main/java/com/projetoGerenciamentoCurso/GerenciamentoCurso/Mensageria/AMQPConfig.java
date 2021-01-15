package com.projetoGerenciamentoCurso.GerenciamentoCurso.Mensageria;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@EnableRabbit
@Configuration

public class AMQPConfig {
	
	
	   @Bean
	    public TopicExchange eventExchange() {
	        
	        return new TopicExchange("Aluno");
	    }
	    
	    @Bean
	    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
	        
	        return new Jackson2JsonMessageConverter();
	    }
	    
	    @Bean
	    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
	        
	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
	        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
	        
	        return rabbitTemplate;
	    }

}
