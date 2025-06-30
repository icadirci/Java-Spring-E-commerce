package com.shoppro.shoppro_auth.config;

import com.shoppro.shoppro_auth.enums.RabbitMqQueueType;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class RabbitMqConfig {

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    public void setupRabbitMq() {
        for (RabbitMqQueueType type : RabbitMqQueueType.values()) {
            Queue queue = new Queue(type.getQueueName(), true);
            DirectExchange exchange = new DirectExchange(type.getExchangeName(), true, false);
            Binding binding = BindingBuilder.bind(queue)
                    .to(exchange)
                    .with(type.getRoutingKey());

            amqpAdmin.declareQueue(queue);
            amqpAdmin.declareExchange(exchange);
            amqpAdmin.declareBinding(binding);
        }
    }
}
