package com.study.designpatterns.seungchan_moon._14_command.after;

import com.study.designpatterns.seungchan_moon._14_command.before.Game;

public class GameEndCommand implements Command {
    private Game game;

    public GameEndCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.start();
    }

    @Override
    public void undo() {
        new GameEndCommand(this.game).execute();
    }
}
