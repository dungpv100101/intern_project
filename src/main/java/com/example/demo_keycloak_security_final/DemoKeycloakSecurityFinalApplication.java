package com.example.demo_keycloak_security_final;

import com.example.demo_keycloak_security_final.handler.command.CommandHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;

@SpringBootApplication
public class DemoKeycloakSecurityFinalApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoKeycloakSecurityFinalApplication.class, args);

		Map<String, RedisOperations> map = context.getBeansOfType(RedisOperations.class);
	}

}
