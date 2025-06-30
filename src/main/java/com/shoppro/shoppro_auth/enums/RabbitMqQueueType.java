package com.shoppro.shoppro_auth.enums;

public enum RabbitMqQueueType {
    USER_REGISTERED_NOTIFICATION("user-notification-q", "user-exchange", "user.registered"),
    ORDER_CREATED("order-notification-q", "order-exchange", "order.created"),
    USER_REGISTERED_EMAIL("user-email-q", "user-exchange", "user.registered");

    private final String queueName;
    private final String exchangeName;
    private final String routingKey;

    RabbitMqQueueType(String queueName, String exchangeName, String routingKey) {
        this.queueName = queueName;
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
    }

    public String getQueueName() {
        return queueName;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public String getRoutingKey() {
        return routingKey;
    }


}
