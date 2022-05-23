package com.study.designpatterns.seungchan_moon._6_adapter;

import com.study.designpatterns.seungchan_moon._6_adapter.security.UserDetails;
import com.study.designpatterns.seungchan_moon._6_adapter.security.UserDetailsService;

public class AccountUserDetailsService implements UserDetailsService {

    AccountService accountService;

    public AccountUserDetailsService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUser(String username) {
        Account account = accountService.findAccountByUsername(username);
        return new AccountUserDetails(account);
    }
}
