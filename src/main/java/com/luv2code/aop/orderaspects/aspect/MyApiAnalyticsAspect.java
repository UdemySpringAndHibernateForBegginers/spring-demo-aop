package com.luv2code.aop.orderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {

    @Before("forDaoPackageNoGettersNoSetters()") //przykład skorzystania z powyższego COMBINE POINTCUT EXPRESSION
    public void performApiAnalytics() {
        System.out.println("**** Advice method: Performing API analytics...");
    }

}
