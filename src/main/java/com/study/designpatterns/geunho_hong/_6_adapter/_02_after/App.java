package com.study.designpatterns.geunho_hong._6_adapter._02_after;

import com.study.designpatterns.geunho_hong._6_adapter._01_before.security.LoginHandler;
import com.study.designpatterns.geunho_hong._6_adapter._01_before.security.UserDetailsService;


public class App {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        UserDetailsService userDetailsService = (UserDetailsService) new AccountUserDetailsService(accountService);
        LoginHandler loginHandler = new LoginHandler(userDetailsService);
        String login = loginHandler.login("keesun", "keesun");
        System.out.println(login);
    }
}
