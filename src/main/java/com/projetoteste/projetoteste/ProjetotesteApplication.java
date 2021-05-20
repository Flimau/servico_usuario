package com.projetoteste.projetoteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetotesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetotesteApplication.class, args);
	}

}
