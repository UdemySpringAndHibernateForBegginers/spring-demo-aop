package com.luv2code.aop.simpleexample.app;

import com.luv2code.aop.simpleexample.config.DemoConfig;
import com.luv2code.aop.simpleexample.dao.AccountDao;
import com.luv2code.aop.simpleexample.dao.MembershipDao;
import com.luv2code.aop.simpleexample.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

        //call the business method
        accountDao.addAccount(new Account("afwqef", "wqefewf"), true);
        membershipDao.addMembership();
        accountDao.doWork();
        membershipDao.goToSleep();

        //close the context
        context.close();
    }
}
