package com.luv2code.aop.readjoinpoint.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

    public boolean addMembership() {
        System.out.println(getClass() + ": doing my DB work: adding new membership");
        return true;
    }

    public void goToSleep() {
        System.out.println(getClass() + ": going to sleep");
    }
}
