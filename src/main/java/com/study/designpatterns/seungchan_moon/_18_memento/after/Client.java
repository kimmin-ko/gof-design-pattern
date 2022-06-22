package com.study.designpatterns.seungchan_moon._18_memento.after;

public class Client {

    public static void main(String[] args) {
        Game game = new Game();
        game.setBlueTeamScore(10);
        game.setRedTeamScore(20);

        GameSave save = game.save();
        game.setBlueTeamScore(11);
        game.setRedTeamScore(22);

        System.out.println(game.getBlueTeamScore());
        System.out.println("game.getRedTeamScore() = " + game.getRedTeamScore());

        game.restore(save);
        System.out.println(game.getBlueTeamScore());
        System.out.println("game.getRedTeamScore() = " + game.getRedTeamScore());
        
    }
}
