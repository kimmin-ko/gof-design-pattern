package com.study.designpatterns.seungchan_moon._14_command.after;

import com.study.designpatterns.seungchan_moon._14_command.before.Game;

public class GameStartCommand implements Command {
    private Game game;

    public GameStartCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }

    @Override
    public void undo() {
        new GameStartCommand(this.game).execute();
    }
}
