package com.study.designpatterns.min_kim._14_command._1_before;

public class Button {

    private final Game game;

    public Button(Game game) {
        this.game = game;
    }

    public void press() {
        game.start();
    }

    public static void main(String[] args) {
        Button button = new Button(new Game());
        button.press();
        button.press();
    }
}
