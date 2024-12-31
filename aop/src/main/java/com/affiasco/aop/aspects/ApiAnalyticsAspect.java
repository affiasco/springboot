package com.affiasco.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

    @Before("com.affiasco.aop.aspects.AopExpressions.forDaoPackageNoGetterSetter()") // reuse the pointcut expression
    public void performApiAnalytics() {
        System.out.println("=====>>> Performing API analytics <<<=====\n");
    }
}
