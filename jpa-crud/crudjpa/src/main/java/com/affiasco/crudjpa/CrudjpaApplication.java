package com.affiasco.crudjpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudjpaApplication.class, args);
	}

	@Bean
//	public CommandLineRunner commandLineRunner(String[] args) {
	public CommandLineRunner commandLineRunner() {
		return runner -> {
			System.out.println("Welcome to Crudjpa!");
		};
	}

}
