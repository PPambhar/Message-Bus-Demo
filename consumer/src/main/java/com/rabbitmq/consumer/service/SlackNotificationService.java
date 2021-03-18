package com.rabbitmq.consumer.service;

import com.rabbitmq.consumer.dto.Payload;
import com.rabbitmq.consumer.dto.SlackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SlackNotificationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${slack.webhook.url}")
    private String slackWebhook;

    public void sendSlackNotification(SlackDto slackDto) {
        final String uri = slackWebhook;
        Payload payload = new Payload(slackDto.getText());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Payload> requestEntity = new HttpEntity<>(payload, headers);
        String result = restTemplate.postForObject(uri, requestEntity, String.class);
        System.out.println(result);
    }
}
