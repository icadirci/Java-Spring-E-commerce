package com.shoppro.shoppro_auth.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    @RabbitListener(queues = "user-email-q")
    public void consumeUserEmail(String message) {
        System.out.println("Email Gönderildi: " + message);
    }
}
