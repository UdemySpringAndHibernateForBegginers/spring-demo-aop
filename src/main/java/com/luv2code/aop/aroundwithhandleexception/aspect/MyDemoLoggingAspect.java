package com.luv2code.aop.aroundwithhandleexception.aspect;

import com.luv2code.aop.aroundwithhandleexception.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
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

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aop.aroundwithhandleexception.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        //wypisanie na rzecz jakiej metody uruchomiona zostałą porada
        Signature signature = joinPoint.getSignature();
        System.out.println("**** Advice method: Executing @AfterReturning advice on method: " + signature);

        //wypisanie wyniku przechwyconej metody:
        System.out.println("**** Advice method: Executing @AfterReturning advice; method result: " + result);

        //modyfikacja tego co zwróciła metoda!!!!!!
        //zmiana pola name na uppercase
        result.forEach(x -> {
            String upperCase = x.getName().toUpperCase();
            x.setName(upperCase);
        });

        //wypisanie modyfikowanego wyniku
        System.out.println("**** Advice method: Executing @AfterReturning advice; method MODIFIED result: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.luv2code.aop.aroundwithhandleexception.dao.AccountDao.findAccounts(..))",
            throwing = "theException"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theException) {

        //wypisanie metody, którą właśnie przechwyciliśmy
        Signature signature = joinPoint.getSignature();
        System.out.println("**** Advice method: Executing @AfterThrowing advice on method: " + signature);

        //zalogowanie wyjatku
        System.out.println("**** Advice method: the exception is: " + theException);

    }

    @After("execution(* com.luv2code.aop.aroundwithhandleexception.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {

        //wypisanie metody, którą właśnie przechwyciliśmy
        Signature signature = joinPoint.getSignature();
        System.out.println("**** Advice method: Executing @After (finally) advice on method: " + signature);

    }

    @Around("execution(* com.luv2code.aop.aroundwithhandleexception.service.*.getFortune(..))")
    public Object aroungGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //wypisanie metody, którą właśnie przechwyciliśmy
        Signature signature = proceedingJoinPoint.getSignature();
        System.out.println("**** Around advice: Executing @Around advice on method: " + signature);

        //get the begin timestamp
        long begin = System.currentTimeMillis();

        //uruchomienie metody docelowej / przechwytywanej!!!!
        Object result = null;

        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {

            //logujemy wyjątek
            log.warn("Uwaga, nastąpił wyjątek: " + e.getMessage());

            //podstawiamy jakąś inną wartość pod to co zwróciłąby metoda docelowa / przechwycona!!!!!!!
            //dzięki temu główny program nawet się nie dowie, że metoda docelowa rzuciłą wyjątekiem
            result = "oto jakiś domyślny wynik metody getFortune()!!!";
        }

        //get the begin timestamp
        long end = System.currentTimeMillis();

        //wyznaczenie duration
        long duration = end - begin;
        System.out.println("**** Around advice: duration: " + duration);

        return result;
    }

}
