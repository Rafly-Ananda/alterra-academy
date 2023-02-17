package com.alterra.swaggerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SwaggerApiApplication {

	// Swagger API Documentation URL is at http://localhost:8080/swagger-ui/index.html#/

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApiApplication.class, args);
	}

}
