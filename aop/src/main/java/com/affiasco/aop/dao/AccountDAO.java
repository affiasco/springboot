package com.affiasco.aop.dao;

import com.affiasco.aop.Account;

public interface AccountDAO {

    void addAccount();
    void addAccount2(Account theAccount);
    void addAccount3(Account theAccount, boolean vipFlag);
    boolean completedWork();
}
