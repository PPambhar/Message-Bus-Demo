package com.rabbitmq.producer.service;

import com.rabbitmq.producer.dto.EmailDto;
import com.rabbitmq.producer.dto.SlackDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

//    public void pushToEmailQueue(EmailDto emailDto) {
//        rabbitTemplate.convertAndSend("direct-exchange", "email.route", emailDto);
//    }
//
//    public void pushToSlackQueue(SlackDto slackDto) {
//        rabbitTemplate.convertAndSend("direct-exchange", "slack.route", slackDto);
//    }
//
//    public void pushToSlackQueue2(SlackDto slackDto) {
//        rabbitTemplate.convertAndSend("direct-exchange", "slack2.route", slackDto);
//    }

    public void pushToTopicExchange(Object object) {
        rabbitTemplate.convertAndSend("fanout-exchange", "", object);
    }
}