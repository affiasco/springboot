package com.affiasco.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    //    pointcut declaration
    @Pointcut("execution(* com.affiasco.aop.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.affiasco.aop.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.affiasco.aop.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter()  || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
