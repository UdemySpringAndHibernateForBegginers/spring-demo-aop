package com.luv2code.aop.combinepointcutdeclaration.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aop.combinepointcutdeclaration.dao.*.*(..))") //uruchomi się dla wszystkich metod z zadanego pakietu, bez względu na nazwę i parametry
    private void forDaoPackage() {}


    @Before("forDaoPackage()") //przykład skorzystania z powyższego pointcut declaration
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice on below method...");
    }

    @Before("forDaoPackage()") //przykład skorzystania z powyższego pointcut declaration
    public void performApiAnalytics() {
        System.out.println("Performing API analytics...");
    }
}
