package com.luv2code.aop.afterreturning.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExpressionContainer {

    @Pointcut("execution(* com.luv2code.aop.afterreturning.dao.*.*(..))") //uruchomi się dla wszystkich metod z zadanego pakietu, bez względu na nazwę i parametry
    public void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.aop.afterreturning.dao.*.get*(..))") //uruchomi się dla wszystkich getterów z zadanego pakietu
    public void forGetters() {}

    @Pointcut("execution(* com.luv2code.aop.afterreturning.dao.*.set*(..))") //uruchomi się dla wszystkich setterów z zadanego pakietu
    public void forSetters() {}

    @Pointcut("forDaoPackage() && !(forGetters() || forSetters())") // COMBINE POINTCUT EXPRESSION
    public void forDaoPackageNoGettersNoSetters() {}               // uruchomi się dla wszystkich metod z zadanego pakietu, bez względu na nazwę i parametry
                                                                    // ale NIE dla getterów i setterów !!!!

}
