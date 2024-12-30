package com.affiasco.aop;

import com.affiasco.aop.dao.AccountDAO;
import com.affiasco.aop.dao.MembershipDAO;
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
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            System.out.println("In the runner");

            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
        };
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        // call the business methods
        theAccountDAO.addAccount();
        theMembershipDAO.addAccount();
        theAccountDAO.addAccount2(new Account());
        theAccountDAO.addAccount3(new Account(), true);
        theAccountDAO.completedWork();
        theMembershipDAO.addNewMember();
        theMembershipDAO.sleep();
    }
}
