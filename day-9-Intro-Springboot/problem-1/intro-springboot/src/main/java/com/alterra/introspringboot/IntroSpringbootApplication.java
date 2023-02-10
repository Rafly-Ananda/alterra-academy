package com.alterra.introspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("/v1/messages")
public class IntroSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntroSpringbootApplication.class, args);
	}

	@GetMapping
	public String grettingGet() {
		return "Hello World";
	}

	@PostMapping
	public String greetingPost() {
		return "Hello World";
	}

	@DeleteMapping
	public String greetingDelete() {
		return "Hello World";
	}

}
