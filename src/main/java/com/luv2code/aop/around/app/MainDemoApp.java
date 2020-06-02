package com.luv2code.aop.around.app;

import com.luv2code.aop.around.config.DemoConfig;
import com.luv2code.aop.around.dao.AccountDao;
import com.luv2code.aop.around.model.Account;
import com.luv2code.aop.around.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        //uruchomienie metody
        System.out.println("Uruchamiam getFortune!");
        String data = trafficFortuneService.getFortune();
        System.out.println("My fortune is: " + data);
        System.out.println("Finished.");

        //close the context
        context.close();
    }
}
