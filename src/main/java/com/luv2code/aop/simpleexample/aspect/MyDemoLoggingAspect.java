package com.luv2code.aop.simpleexample.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

//    @Before("execution(public void addAccount())") //uruchomi się dla metody public void addAccount z dowolnej klasy
//    @Before("execution(public void com.luv2code.aop.simpleexample.dao.AccountDao.addAccount())") //uruchomi się dla metody public void addAccount ze wskazanej klasy
//    @Before("execution(public void add*())") //uruchomi się dla wszystkich metod public void rozpoczynających się od "add" z dowolnej klasy
//    @Before("execution(void add*())") //uruchomi się dla metody void rozpoczynającej się od "add" z dowolnej klasy
//    @Before("execution(* add*(com.luv2code.aop.simpleexample.model.Account))") //uruchomi się dla metody o dowolnym modyfikatorze dostępu, zwracajacej dowolny typ danych, o nazwie rozpoczynającej się od add i przyjmujęcej parametr typu com.luv2code.aop.simpleexample.model.Account
//    @Before("execution(* add*(com.luv2code.aop.simpleexample.model.Account, ..))") //uruchomi się dla metody o dowolnym modyfikatorze dostępu, zwracajacej dowolny typ danych, o nazwie rozpoczynającej się od add i przyjmujęcej parametr typu com.luv2code.aop.simpleexample.model.Account a następnie zero lub więcej dowolnych parametrów
    @Before("execution(* com.luv2code.aop.simpleexample.dao.*.*(..))") //uruchomi się dla wszystkich metod z zadanego pakietu, bez względu na nazwę i parametry
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice on below method...");
    }
}
