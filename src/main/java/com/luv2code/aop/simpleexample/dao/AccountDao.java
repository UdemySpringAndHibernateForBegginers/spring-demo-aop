package com.luv2code.aop.simpleexample.dao;

import com.luv2code.aop.simpleexample.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    public void addAccount() {
        System.out.println(getClass() + ": doing my DB work: adding new account");
    }

    public void addAccount(Account account) {
        System.out.println(getClass() + ": doing my DB work: adding new account (method with parameter)");
    }

    public void addAccount(Account account, boolean flag) {
        System.out.println(getClass() + ": doing my DB work: adding new account (method with two different parameter)");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doing my work");
        return false;
    }
}
