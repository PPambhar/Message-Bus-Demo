package com.rabbitmq.consumer.service;
import com.rabbitmq.consumer.dto.EmailDto;
import com.rabbitmq.consumer.dto.SlackDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageListener {

    @Autowired
    private SlackNotificationService slackNotificationService;

    @Autowired
    private EmailNotificationService emailNotificationService;

    @RabbitListener(queues = "email.queue")
    public void receiveMessageFromEmailQueue(Object object) {
//        emailNotificationService.sendMail(emailDto);
        System.out.println("Email Queue");
    }

    @RabbitListener(queues = "slack.queue")
    public void receiveMessageFromSlackQueue(Object object) {
        System.out.println("Slack Queue");
    }

    @RabbitListener(queues = "slack2.queue")
    public void receiveMessageFromSlackQueue2(Object object) {
        System.out.println("Slack-2 Queue");
    }

    @RabbitListener(queues = "trello.queue")
    public void receiveMessageFromTrello(Object object) {
        System.out.println("Trello Queue");
    }

    @RabbitListener(queues = "jira.queue")
    public void receiveMessageFromJira(Object object) {
        System.out.println("Jira Queue");
    }
}
