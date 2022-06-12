package com.study.designpatterns.min_kim._18_memento._2_after;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Game {
    private int redTeamScore;
    private int blueTeamScore;

    public GameSave save() {
        return new GameSave(redTeamScore, blueTeamScore);
    }

    public void restore(GameSave gameSave) {
        this.redTeamScore = gameSave.getBludTeamScore();
        this.blueTeamScore = gameSave.getBludTeamScore();
    }
}
