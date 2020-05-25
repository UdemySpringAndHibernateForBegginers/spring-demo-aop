package com.luv2code.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount() {
        System.out.println(getClass() + ": doing my DB work: adding new account");

    }
}
