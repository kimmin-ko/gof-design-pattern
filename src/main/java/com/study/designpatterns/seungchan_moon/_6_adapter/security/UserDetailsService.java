package com.study.designpatterns.seungchan_moon._6_adapter.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);
}
