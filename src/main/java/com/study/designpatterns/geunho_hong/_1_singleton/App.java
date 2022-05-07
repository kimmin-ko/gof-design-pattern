package com.study.designpatterns.geunho_hong._1_singleton;

public class App {
    public static void main(String[] args) {
        Settings settings = Settings.getInstance();
        System.out.println(settings == Settings.getInstance());
    }
}
