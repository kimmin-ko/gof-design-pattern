package com.study.designpatterns.seungchan_moon._1_singleton;

public class App {

    public static void main(String[] args) {
        System.out.println(Settings_1.getInstance() == Settings_1.getInstance());
        System.out.println(Settings_2.getInstance() == Settings_2.getInstance());
        System.out.println(Settings_3.getInstance() == Settings_3.getInstance());
        System.out.println(Settings_4.getInstance() == Settings_4.getInstance());
    }
}
