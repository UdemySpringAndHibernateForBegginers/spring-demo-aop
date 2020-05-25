package com.luv2code.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public void addAccount() {
        System.out.println(getClass() + ": doing my DB work: adding new account 2222222");

    }
}
