package com.study.designpatterns.geunho_hong._3_adapter._02_after.security;

public interface UserDetailsService {

    UserDetails loadUser(String username);

}
