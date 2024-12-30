package com.affiasco.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // add related advices for logging

//    @Before("execution(public void addAccount())") // run this code BEFORE target method 'public void addAccount()'
//    @Before("execution(public void com.affiasco.aop.dao.AccountDAO.addAccount())") // need the fully qualified className to be specific to an individual account
//    @Before("execution(public void add*())") // matches on any method starting with add
//    @Before("execution(void add*())") // matches on a given return type void and add*
    @Before("execution(void add*())") //
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on addAccount() <<<=====");
    }
}
