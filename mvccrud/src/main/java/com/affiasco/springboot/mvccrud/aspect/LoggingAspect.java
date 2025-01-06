package com.affiasco.springboot.mvccrud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {
    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.affiasco.springboot.mvccrud.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.affiasco.springboot.mvccrud.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.affiasco.springboot.mvccrud.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {
    }

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("in @Before calling method: " + method);

        Object[] args = theJoinPoint.getArgs();

        for (Object a : args) {
            myLogger.info("argument: " + a);
        }
    }

    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "result")
    public void afterReturning(JoinPoint theJoinPoint, Object result) {
        String method = theJoinPoint.getSignature().toShortString();
        myLogger.info("in @AfterReturning calling method: " + method);

        myLogger.info("@AfterReturning result: " + result);
    }
}
