package com.affiasco.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {

    @Before("com.affiasco.aop.aspects.AopExpressions.forDaoPackageNoGetterSetter()") // have to give fully qualified class name
    public void logToCloudAsync(){
        System.out.println("\n=====>>> Logging to Cloud in async <<<=====");
    }
}
