package com.study.designpatterns.min_kim._6_adapter.security;

public interface UserDetailsService {
    UserDetails loadUser(String username);
}
