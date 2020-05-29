package com.luv2code.aop.afterreturning.app;

import com.luv2code.aop.afterreturning.config.DemoConfig;
import com.luv2code.aop.afterreturning.dao.AccountDao;
import com.luv2code.aop.afterreturning.dao.MembershipDao;
import com.luv2code.aop.afterreturning.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        // call the new method for finding account
        List<Account> accounts = accountDao.findAccounts();

        System.out.println("Oto wynik metody findAccounts:");
        accounts.forEach(System.out::println);

        //close the context
        context.close();
    }
}
