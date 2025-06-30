package com.shoppro.shoppro_auth.messaging.producer;

import com.shoppro.shoppro_auth.enums.RabbitMqQueueType;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqProducer {

    @Autowired private RabbitTemplate rabbitTemplate;

    public void sendMessage(RabbitMqQueueType type, String message) {
        rabbitTemplate.convertAndSend(
                type.getExchangeName(),
                type.getRoutingKey(),
                message
        );
    }
}
