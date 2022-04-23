package com.study.designpatterns.yunjin_choi._4_builder;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._4_builder
 *      App
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-10 오후 9:26
 */

public class App {
    public static void main(String[] args) {

        PersonBuilder builder = new Person();
        Person person = builder.name("YunJin Choi")
                .birthday(1993, 9, 25)
                .email("zzdd1558@gmail.com")
                .phoneNumber("01077599183")
                .address(new Address.Builder()
                        .zipCode("12345")
                        .address1("관악구")
                        .address2("봉천동")
                        .build())
                .build();
    }
}
