package com.luv2code.aop.orderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //przykład skorzystania z COMBINE POINTCUT EXPRESSION zdefiniowanego w klasie com.luv2code.aop.orderaspects.aspect.AopPointcutExpressionContainer
    @Before("com.luv2code.aop.orderaspects.aspect.AopPointcutExpressionContainer.forDaoPackageNoGettersNoSetters()")
    public void beforeAddAccountAdvice() {
        System.out.println("**** Advice method: Executing @Before advice on below method...");
    }

}
