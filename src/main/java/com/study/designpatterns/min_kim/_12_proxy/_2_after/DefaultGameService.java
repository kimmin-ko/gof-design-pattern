package com.study.designpatterns.min_kim._12_proxy._2_after;

public class DefaultGameService implements GameService {
    
    @Override
    public void startGame() {
        System.out.println("이 자리에 오신 여려분을 진심으로 환영합니다.");
    }
}
