package com.study.designpatterns.min_kim._6_adapter;

public class Account {

    private String username;

    private String password;

    private String email;

    public Account(String username) {
        this.username = username;
        this.password = username;
        this.email = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
