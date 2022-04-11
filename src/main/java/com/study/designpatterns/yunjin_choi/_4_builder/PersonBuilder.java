package com.study.designpatterns.yunjin_choi._4_builder;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._4_builder
 *      PersonBuilder
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-10 오후 9:48
 */

public interface PersonBuilder {

    PersonBuilder name(String name);
    PersonBuilder address(Address address);
    PersonBuilder email(String email);
    PersonBuilder phoneNumber(String phoneNumber);
    PersonBuilder birthday(int year, int month, int days);
    Person build();
}
