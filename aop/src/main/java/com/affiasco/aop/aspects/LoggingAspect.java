package com.affiasco.aop.aspects;

import com.affiasco.aop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {
//    add related advices for logging
//    @Before("execution(public void addAccount())") // run this code BEFORE target method 'public void addAccount()'
//    @Before("execution(public void com.affiasco.aop.dao.AccountDAO.addAccount())") // need the fully qualified className to be specific to an individual account
//    @Before("execution(public void add*())") // matches on any method starting with add
//    @Before("execution(void add*())") // matches on a given return type void and add*
//    @Before("execution(* add*(com.affiasco.aop.Account))") // give fully qualified class name to pass Account class as matching param
//    @Before("execution(* com.affiasco..add*(..))") // match on any number of args
//    @Before("execution(* add*(com.affiasco.aop.Account, ..))") // match on account, any number of args
//    @Before("execution(* com.affiasco.aop.dao.*.*(..))") // match on any class (*), method(*) within a package
    @Before("com.affiasco.aop.aspects.AopExpressions.forDaoPackageNoGetterSetter()") // use the defined pointcut expression
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) { // joinpoint gives metadata about method being executed
        System.out.println("=====>>> Executing @Before advice on methods() <<<=====");

        // display method signature
        MethodSignature methSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methSig);

        // display method args
        Object[] args = theJoinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account){
                //downcast and print Account specifics
                Account theAccount = (Account) arg;
                System.out.println("from meth args account name: " + theAccount.getName());
                System.out.println("from meth args account level: " + theAccount.getLevel());
            }
        }
    }
}
