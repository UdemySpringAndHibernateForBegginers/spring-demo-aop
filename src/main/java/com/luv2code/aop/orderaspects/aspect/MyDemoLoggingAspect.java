package com.luv2code.aop.orderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("forDaoPackageNoGettersNoSetters()") //przykład skorzystania z powyższego COMBINE POINTCUT EXPRESSION
    public void beforeAddAccountAdvice() {
        System.out.println("**** Advice method: Executing @Before advice on below method...");
    }

}
