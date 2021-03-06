package com.luv2code.aop.aroundwithlogger.app;

import com.luv2code.aop.aroundwithlogger.config.DemoConfig;
import com.luv2code.aop.aroundwithlogger.service.TrafficFortuneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class MainDemoApp {

    public static void main(String[] args) {

        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        //get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        //uruchomienie metody
        log.info("Uruchamiam getFortune!");
        String data = trafficFortuneService.getFortune();
        log.info("My fortune is: " + data);
        log.info("Finished.");

        //close the context
        context.close();
    }
}
