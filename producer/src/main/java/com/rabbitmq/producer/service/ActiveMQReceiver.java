package com.rabbitmq.producer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQReceiver {
    @JmsListener(destination = "test.queue")
    public void onMessage(String content) {
        System.out.println(content);
    }
}
