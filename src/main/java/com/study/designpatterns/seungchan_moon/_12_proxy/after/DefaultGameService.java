package com.study.designpatterns.seungchan_moon._12_proxy.after;

public class DefaultGameService implements GameService {

    @Override
    public void start() {
        System.out.println("게임을 시작합니다.");
    }
}
