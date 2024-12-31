package com.affiasco.aop;

import com.affiasco.aop.dao.AccountDAO;
import com.affiasco.aop.dao.MembershipDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        return runner -> {
            System.out.println("In the runner");

//            demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
            demoTheAfterReturnAdvice(theAccountDAO);
        };
    }

    private void demoTheAfterReturnAdvice(AccountDAO theAccountDAO) {
        List<Account> accounts = theAccountDAO.findAccounts();
        System.out.println("**** Main Program: demoTheAfterReturnAdvice ****");
        System.out.println("-------");

        System.out.println(accounts);

        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {
        // call the account business methods
        System.out.println("\n***** ACCOUNT *****");
        theAccountDAO.addAccount();

        Account a1 = new Account("First", "Silver");
        theAccountDAO.addAccount2(a1);

        Account a2 = new Account("Second", "Titanium");
        theAccountDAO.addAccount3(a2, true);
        theAccountDAO.completedWork();

        System.out.println("\n***** ACCT GETTER/SETTER *****\n");
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String serviceCode = theAccountDAO.getServiceCode();

        System.out.println("\n***** MEMBERSHIP *****");
        theMembershipDAO.addAccount();
        theMembershipDAO.addNewMember();
        theMembershipDAO.sleep();


    }
}
