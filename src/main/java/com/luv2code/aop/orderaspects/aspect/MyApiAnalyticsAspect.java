package com.luv2code.aop.orderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyApiAnalyticsAspect {

    //przykład skorzystania z COMBINE POINTCUT EXPRESSION zdefiniowanego w klasie com.luv2code.aop.orderaspects.aspect.AopPointcutExpressionContainer
    @Before("com.luv2code.aop.orderaspects.aspect.AopPointcutExpressionContainer.forDaoPackageNoGettersNoSetters()")
    public void performApiAnalytics() {
        System.out.println("**** Advice method: Performing API analytics...");
    }

}
