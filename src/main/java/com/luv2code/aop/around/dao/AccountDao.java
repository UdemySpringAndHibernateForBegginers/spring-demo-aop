package com.luv2code.aop.around.dao;

import com.luv2code.aop.around.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

    public List<Account> findAccounts(boolean rzucWyjatek) {

        if (rzucWyjatek) {
            throw new RuntimeException("Oto umyślny wyjątek!");
        }

        List<Account> list = new ArrayList<>();

        Account account = new Account("name_1", "level_1");
        Account account2 = new Account("name_2", "level_2");
        Account account3 = new Account("name_3", "level_3");

        list.add(account);
        list.add(account2);
        list.add(account3);

        return list;
    }
}
