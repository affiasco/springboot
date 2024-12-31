package com.affiasco.aop.dao;

import com.affiasco.aop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList<>();

        // sample accounts
        Account a1 = new Account("Jon", "Silver");
        Account a2 = new Account("Mads", "Platnium");
        Account a3 = new Account("Luka", "Gold");

        myAccounts.add(a1);
        myAccounts.add(a2);
        myAccounts.add(a3);
        
        return myAccounts;
    }

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

    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
