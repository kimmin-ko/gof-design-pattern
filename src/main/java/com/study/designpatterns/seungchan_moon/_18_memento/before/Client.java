package com.study.designpatterns.seungchan_moon._18_memento.before;

public class Client {

    public static void main(String[] args) {
        Game game = new Game();
        game.setRedTeamScore(20);
        game.setBlueTeamScore(30);

        int blueTeamScore = game.getBlueTeamScore();
        int redTeamScore = game.getRedTeamScore();

        Game restoredGame = new Game();
        restoredGame.setBlueTeamScore(blueTeamScore);
        restoredGame.setRedTeamScore(redTeamScore);

        System.out.println("restoredGame.getRedTeamScore() = " + restoredGame.getRedTeamScore());
        System.out.println("restoredGame.getBlueTeamScore() = " + restoredGame.getBlueTeamScore());

    }
}
