package com.study.designpatterns.seungchan_moon._14_command.java;

import com.study.designpatterns.seungchan_moon._14_command.before.Game;
import com.study.designpatterns.seungchan_moon._14_command.before.Light;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandInJava {

    public static void main(String[] args) {
        Light light = new Light();
        Game game = new Game();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                light.on();
            }
        });
        executorService.submit(game::start);
        executorService.submit(game::end);
        executorService.submit(light::off);
        executorService.shutdown();
    }
}
