package com.affiasco.advmap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvmapApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr() {

        return runner -> {
            System.out.println("Hello from runner");
        };
    }

}
