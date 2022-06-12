package com.study.designpatterns.min_kim._18_memento._2_after;

public class Client {

    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(10);
        game.setBlueTeamScore(20);

        GameSave save = game.save();

        game.setRedTeamScore(200);
        game.setBlueTeamScore(100);

        game.restore(save);
        System.out.println(game.getRedTeamScore());
        System.out.println(game.getBlueTeamScore());
    }
}
