package com.luv2code.aop.app;

import com.luv2code.aop.config.DemoConfig;
import com.luv2code.aop.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        //call the business method
        accountDao.addAccount();

        //close the context
        context.close();
    }
}
