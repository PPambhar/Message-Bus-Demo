package com.rabbitmq.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    FanoutExchange exchange() {
        return new FanoutExchange("fanout-exchange");
    }

    @Bean
    Queue queue1() {
        return new Queue("email.queue", false);
    }

    @Bean
    Binding binding1(Queue queue1, FanoutExchange  exchange) {
        return BindingBuilder.bind(queue1).to(exchange);
    }

    @Bean
    Queue trelloQueue() {
        return new Queue("trello.queue", false);
    }

    @Bean
    Binding trelloBinding(Queue trelloQueue, FanoutExchange  exchange) {
        return BindingBuilder.bind(trelloQueue).to(exchange);
    }

    @Bean
    Queue jiraQueue() {
        return new Queue("jira.queue", false);
    }

    @Bean
    Binding jiraBinding(Queue jiraQueue, FanoutExchange  exchange) {
        return BindingBuilder.bind(jiraQueue).to(exchange);
    }

    @Bean
    Queue queue2() {
        return new Queue("slack.queue", false);
    }


    @Bean
    Binding binding2(Queue queue2, FanoutExchange  exchange) {
        return BindingBuilder.bind(queue2).to(exchange);
    }

    @Bean
    Queue queue3() {
        return new Queue("slack2.queue", false);
    }


    @Bean
    Binding binding3(Queue queue3, FanoutExchange  exchange) {
        return BindingBuilder.bind(queue3).to(exchange);
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}