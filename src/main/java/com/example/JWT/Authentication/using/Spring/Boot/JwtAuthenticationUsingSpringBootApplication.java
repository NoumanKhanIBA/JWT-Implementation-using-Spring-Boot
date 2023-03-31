package com.example.JWT.Authentication.using.Spring.Boot;

import com.example.JWT.Authentication.using.Spring.Boot.model.Members;
import com.example.JWT.Authentication.using.Spring.Boot.repository.MemberRepository;
import com.example.JWT.Authentication.using.Spring.Boot.service.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JwtAuthenticationUsingSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(JwtAuthenticationUsingSpringBootApplication.class, args);
	}

}
