package com.study.designpatterns.min_kim._18_memento._2_after;

import lombok.Getter;

@Getter
public class GameSave {
    private final int redTeamScore;
    private final int bludTeamScore;

    public GameSave(int redTeamScore, int bludTeamScore) {
        this.redTeamScore = redTeamScore;
        this.bludTeamScore = bludTeamScore;
    }
}
