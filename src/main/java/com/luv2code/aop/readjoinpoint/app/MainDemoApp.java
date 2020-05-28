package com.luv2code.aop.readjoinpoint.app;

import com.luv2code.aop.readjoinpoint.config.DemoConfig;
import com.luv2code.aop.readjoinpoint.dao.AccountDao;
import com.luv2code.aop.readjoinpoint.dao.MembershipDao;
import com.luv2code.aop.readjoinpoint.model.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);
        MembershipDao membershipDao = context.getBean("membershipDao", MembershipDao.class);

        //use getter and setter
        accountDao.setName("foobar");
        accountDao.setServiceCode("silver");

        String tmpName = accountDao.getName();
        String tmpServiceCode = accountDao.getServiceCode();

        //call the business method
        accountDao.addAccount(new Account("afwqef", "wqefewf"), true);
        membershipDao.addMembership();
        accountDao.doWork();
        membershipDao.goToSleep();

        //close the context
        context.close();
    }
}
