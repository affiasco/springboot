package com.affiasco.aop.dao;

import com.affiasco.aop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my DB WORK - Adding an account");
    }

    @Override
    public void addAccount2(Account theAccount) {
        System.out.println(getClass() + ": and the account " + theAccount);
    }

    @Override
    public void addAccount3(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": and the account " + theAccount + " vip status: " + vipFlag);
    }

    @Override
    public boolean completedWork() {
        System.out.println(getClass() + ": completed work");
        return false;
    }
}
