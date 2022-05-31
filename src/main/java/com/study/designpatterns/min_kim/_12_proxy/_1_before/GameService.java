package com.study.designpatterns.min_kim._12_proxy._1_before;

public class GameService {

    public void startGame() throws InterruptedException {
        long before = System.currentTimeMillis();
        System.out.println("이 자리에 오신 여려분을 진심으로 환영합니다.");
        System.out.println(System.currentTimeMillis() - before);
    }
}
