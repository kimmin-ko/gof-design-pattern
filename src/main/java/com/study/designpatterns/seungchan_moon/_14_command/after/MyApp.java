package com.study.designpatterns.seungchan_moon._14_command.after;

import com.study.designpatterns.seungchan_moon._14_command.before.Game;

public class MyApp {
    private Command command;

    public MyApp(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }

    public static void main(String[] args) {
        MyApp myApp = new MyApp(new GameStartCommand(new Game()));
        myApp.press();
    }
}
