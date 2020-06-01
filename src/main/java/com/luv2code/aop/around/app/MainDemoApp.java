package com.luv2code.aop.around.app;

import com.luv2code.aop.around.config.DemoConfig;
import com.luv2code.aop.around.dao.AccountDao;
import com.luv2code.aop.around.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        // call the new method for finding account
        List<Account> accounts = null;
        boolean rzucWyjatek = true;
        try {
            accounts = accountDao.findAccounts(rzucWyjatek);
        } catch (Exception e) {
            System.out.println("Main program caught exception: " + e);
        }

        System.out.println("Oto wynik metody findAccounts:");
        accounts.forEach(System.out::println);

        //close the context
        context.close();
    }
}
