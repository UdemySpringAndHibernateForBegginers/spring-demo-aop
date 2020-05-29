package com.luv2code.aop.afterreturning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyCloudLoggingAspect {

    //przykład skorzystania z COMBINE POINTCUT EXPRESSION zdefiniowanego w klasie com.luv2code.aop.afterreturning.aspect.AopPointcutExpressionContainer
    @Before("com.luv2code.aop.afterreturning.aspect.AopPointcutExpressionContainer.forDaoPackageNoGettersNoSetters()")
    public void logToCloudAdvice() {
        System.out.println("**** Advice method: Performing logging to cloud...");
    }
}
