package com.rabbitmq.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class ActiveMQSender {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    public void sendMessage() {
        jmsMessagingTemplate.convertAndSend("test.queue", "Hello Java2blog!!");
    }
}
