package com.Query.query.Mensageria;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import com.Query.query.Model.Aluno;

@Component
public class Consumer {

	 @Autowired
	 private SimpMessagingTemplate simpMessagingTemplate;

	 
	
}
