package com.study.designpatterns.seungchan_moon._1_singleton;

public class App {

    public static void main(String[] args) {
        Settings_1 settings_1_1 = Settings_1.getInstance();
        Settings_1 settings_1_2 = Settings_1.getInstance();
        if (settings_1_2 == settings_1_1) {
            System.out.println("같다");
        }
    }
}
