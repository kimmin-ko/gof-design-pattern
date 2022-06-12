package com.study.designpatterns.min_kim._18_memento._1_before;

public class Client {

    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(10);
        game.setBlueTeamScore(20);

        int redTeamScore = game.getRedTeamScore();
        int blueTeamScore = game.getBlueTeamScore();

        Game restoredGame = new Game();
        restoredGame.setRedTeamScore(redTeamScore);
        restoredGame.setBlueTeamScore(blueTeamScore);
    }
}