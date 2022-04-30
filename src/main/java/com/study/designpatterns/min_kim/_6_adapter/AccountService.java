package com.study.designpatterns.min_kim._6_adapter;

public class AccountService {

    public Account findAccountByUsername(String username) {
        return new Account(username);
    }

    public void save(Account account) {

    }

    public void update(Account account) {

    }
}
