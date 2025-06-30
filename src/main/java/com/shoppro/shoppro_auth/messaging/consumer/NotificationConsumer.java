package com.shoppro.shoppro_auth.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationConsumer {
    @RabbitListener(queues = "user-notification-q")
    public void consumeUserNotification(String message){
        System.out.println("📥 Kullanıcı bildirimi alındı: " + message);
    }

    @RabbitListener(queues = "order-notification-q")
    public void consumeOrderNotification(String message) {
        System.out.println("📥 Sipariş bildirimi alındı: " + message);
    }
}
