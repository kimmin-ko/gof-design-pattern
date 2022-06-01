package com.study.designpatterns.seungchan_moon._12_proxy.java;

import org.springframework.stereotype.Service;

@Service("gameService")
public class GameService {
    public void start() {
        System.out.println("게임을 시작합니다.");
    }
}
