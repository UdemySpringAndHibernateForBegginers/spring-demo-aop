package com.luv2code.aop.orderaspects.dao;

import com.luv2code.aop.orderaspects.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDao {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": in getter getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setter setName");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getter getServiceCdde");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setter setServiceCdde");
        this.serviceCode = serviceCode;
    }

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
