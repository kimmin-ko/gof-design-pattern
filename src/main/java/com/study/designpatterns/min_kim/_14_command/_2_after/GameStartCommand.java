package com.study.designpatterns.min_kim._14_command._2_after;

import com.study.designpatterns.min_kim._14_command._1_before.Game;

public class GameStartCommand implements Command{

    private final Game game;

    public GameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }
}
