package com.study.designpatterns.seungchan_moon._6_adapter;

import com.study.designpatterns.seungchan_moon._6_adapter.security.LoginHandler;
import com.study.designpatterns.seungchan_moon._6_adapter.security.UserDetailsService;

public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("msc", "msc");
        System.out.println(login);
    }
}
