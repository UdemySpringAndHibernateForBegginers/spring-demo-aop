package com.luv2code.aop.around.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneService {

    public String getFortune() {

        //simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return a fortune
        return "Expect heavy traffic this morning!";
    }
}
