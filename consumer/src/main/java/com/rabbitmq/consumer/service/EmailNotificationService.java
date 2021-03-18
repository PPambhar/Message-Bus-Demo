package com.rabbitmq.consumer.service;

import com.rabbitmq.consumer.dto.EmailDto;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailNotificationService {

    public boolean sendMail(EmailDto emailDto) {
        try {
            JavaMailSenderImpl mailSenderRuntime = new JavaMailSenderImpl();

            mailSenderRuntime.setHost("mail.tudu.ai");
            mailSenderRuntime.setPort(Integer.parseInt("587"));
            mailSenderRuntime.setUsername(emailDto.getFrom());
            mailSenderRuntime.setPassword("Pass123$");

            Properties javaMailProperties = new Properties();
            javaMailProperties.put("mail.smtp.starttls.enable", "true");
            javaMailProperties.put("mail.smtp.auth", "true");
            javaMailProperties.put("mail.transport.protocol", "smtp");
            javaMailProperties.put("mail.debug", "true");

            mailSenderRuntime.setJavaMailProperties(javaMailProperties);

            MimeMessage message = mailSenderRuntime.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(emailDto.getTo());
            helper.setFrom(emailDto.getFrom());
            helper.setSubject(emailDto.getSubject());
            helper.setText(emailDto.getContent(), true);
            mailSenderRuntime.send(message);
        }
        catch (Exception e) {
            System.out.println("Error sending mail. Cause: " + e.getMessage());
            return false;
        }
        return true;
    }
}
