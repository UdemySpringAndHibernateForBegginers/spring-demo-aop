package com.luv2code.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void addAccount())") //uruchomi się dla metody public void addAccount z dowolnej klasy
//    @Before("execution(public void com.luv2code.aop.dao.AccountDao.addAccount())") //uruchomi się dla metody public void addAccount ze wskazanej klasy
//    @Before("execution(public void add*())") //uruchomi się dla wszystkich metod public void rozpoczynających się od "add" z dowolnej klasy
    @Before("execution(void add*())") //uruchomi się dla metody void rozpoczynającej się od "add" z dowolnej klasy
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice on below method...");
    }
}
