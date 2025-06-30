package com.shoppro.shoppro_auth;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class ShopproAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopproAuthApplication.class, args);
	}

}
