package com.study.designpatterns.min_kim._6_adapter;

import com.study.designpatterns.min_kim._6_adapter.security.UserDetails;

public class AccountUserDetails implements UserDetails {

    private final Account account;

    public AccountUserDetails(Account account) {
        this.account = account;
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }
}
