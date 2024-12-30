package com.affiasco.aop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB WORK - Adding a membership");
    }

    @Override
    public boolean addNewMember() {
        System.out.println(getClass() + ": Doing my DB WORK - Adding a NEW membership and returning true");
        return true;
    }

    @Override
    public void sleep() {
        System.out.println(getClass() + ": I am sleeping");
    }
}
