package com.affiasco.aop;

import com.affiasco.aop.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO) {
        return runner -> {
            System.out.println("In the runner");

            demoTheBeforeAdice(theAccountDAO);
        };
    }

    private void demoTheBeforeAdice(AccountDAO theAccountDAO) {
        // call the business method
        theAccountDAO.addAccount();
    }


}
