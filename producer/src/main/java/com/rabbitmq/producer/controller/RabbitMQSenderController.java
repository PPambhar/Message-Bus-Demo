package com.rabbitmq.producer.controller;

import com.rabbitmq.producer.dto.EmailDto;
import com.rabbitmq.producer.dto.SlackDto;
import com.rabbitmq.producer.service.ActiveMQSender;
import com.rabbitmq.producer.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rabbitmq")
@CrossOrigin
public class RabbitMQSenderController {

    @Autowired
    RabbitMQSender rabbitMQSender;

    @Autowired
    ActiveMQSender activeMQSender;

    @PostMapping(value = "/producer/email")
    public String emailProducer(@RequestBody EmailDto emailDto) {
        //rabbitMQSender.pushToEmailQueue(emailDto);
        rabbitMQSender.pushToTopicExchange(emailDto);
        return "Message sent to RabbitMQ email Queue";
    }

    @PostMapping(value = "/producer/slack")
    public String slackProducer(@RequestBody SlackDto slackDto) {
        //rabbitMQSender.pushToSlackQueue(slackDto);
        //rabbitMQSender.pushToSlackQueue2(slackDto);
        rabbitMQSender.pushToTopicExchange(slackDto);
        return "Message sent to RabbitMQ Slack Queue";
    }

    @PostMapping(value = "/activeMQ")
    public String sendActiveMQ() {
        activeMQSender.sendMessage();
        return "Message sent to ActiveMQ";
    }
}
