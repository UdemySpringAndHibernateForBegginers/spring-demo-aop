package com.luv2code.aop.orderaspects.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.luv2code.aop.orderaspects.dao.*.*(..))") //uruchomi się dla wszystkich metod z zadanego pakietu, bez względu na nazwę i parametry
    private void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.aop.orderaspects.dao.*.get*(..))") //uruchomi się dla wszystkich getterów z zadanego pakietu
    private void forGetters() {}

    @Pointcut("execution(* com.luv2code.aop.orderaspects.dao.*.set*(..))") //uruchomi się dla wszystkich setterów z zadanego pakietu
    private void forSetters() {}

    @Pointcut("forDaoPackage() && !(forGetters() || forSetters())") // COMBINE POINTCUT EXPRESSION
    private void forDaoPackageNoGettersNoSetters() {}               // uruchomi się dla wszystkich metod z zadanego pakietu, bez względu na nazwę i parametry
                                                                    // ale NIE dla getterów i setterów !!!!


    @Before("forDaoPackageNoGettersNoSetters()") //przykład skorzystania z powyższego COMBINE POINTCUT EXPRESSION
    public void beforeAddAccountAdvice() {
        System.out.println("Executing @Before advice on below method...");
    }

    @Before("forDaoPackageNoGettersNoSetters()") //przykład skorzystania z powyższego COMBINE POINTCUT EXPRESSION
    public void performApiAnalytics() {
        System.out.println("Performing API analytics...");
    }
}
