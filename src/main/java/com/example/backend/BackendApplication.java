package com.example.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	String PORT = System.getenv("PORT");
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
//https://intuitive-peace-production.up.railway.app/login