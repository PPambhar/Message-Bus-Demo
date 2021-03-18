package com.rabbitmq.consumer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQReceiver {
    @JmsListener(destination = "hello.queue")
    public void onMessage(String content) {
        System.out.println(content);
    }
}
