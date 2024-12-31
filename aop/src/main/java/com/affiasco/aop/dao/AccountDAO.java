package com.affiasco.aop.dao;

import com.affiasco.aop.Account;

import java.util.List;

public interface AccountDAO {
    List<Account> findAccounts();

    void addAccount();

    void addAccount2(Account theAccount);

    void addAccount3(Account theAccount, boolean vipFlag);

    boolean completedWork();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
