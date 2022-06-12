package com.study.designpatterns.min_kim._14_command._2_after;

import com.study.designpatterns.min_kim._14_command._1_before.Game;
import com.study.designpatterns.min_kim._14_command._1_before.Light;

public class App {

    public static void main(String[] args) {
        Button lightOnButton = new Button(new LightOnCommand(new Light()));
        lightOnButton.press();

        Button lightOffButton = new Button(new LightOffCommand(new Light()));
        lightOffButton.press();

        Button gameStartButton = new Button(new GameStartCommand(new Game()));
        gameStartButton.press();

        Button gameEndButton = new Button(new GameEndCommand(new Game()));
        gameEndButton.press();
    }
}
