package com.example.JWT.Authentication.using.Spring.Boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JwtAuthenticationUsingSpringBootApplication {

	public static void main(String[] args) {
		System.out.println("Application running");
		SpringApplication.run(JwtAuthenticationUsingSpringBootApplication.class, args);
	}

}
