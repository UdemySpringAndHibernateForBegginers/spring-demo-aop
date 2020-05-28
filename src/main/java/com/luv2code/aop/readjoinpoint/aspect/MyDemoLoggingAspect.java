package com.luv2code.aop.readjoinpoint.aspect;

import com.luv2code.aop.readjoinpoint.model.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order(2)
@Component
public class MyDemoLoggingAspect {

    //przykład skorzystania z COMBINE POINTCUT EXPRESSION zdefiniowanego w klasie com.luv2code.aop.readjoinpoint.aspect.AopPointcutExpressionContainer
    @Before("com.luv2code.aop.readjoinpoint.aspect.AopPointcutExpressionContainer.forDaoPackageNoGettersNoSetters()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("**** Advice method: Executing @Before advice on below method...");

        // display method signature
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("**** Method signature: " + signature);

        // display method arguments
        Object[] args = joinPoint.getArgs();

        Arrays.stream(args).forEach(x -> {
            System.out.println("oto argument: " + x + "; ");
            if (x instanceof Account) {
                System.out.println("accountName: " + ((Account) x).getName());
            }
        });
    }

}
