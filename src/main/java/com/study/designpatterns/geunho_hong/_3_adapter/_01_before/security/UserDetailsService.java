package com.study.designpatterns.geunho_hong._3_adapter._01_before.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
