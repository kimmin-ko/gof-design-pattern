package com.study.designpatterns.min_kim._7_bridge._1_before;

public class 풀파티아리 implements Champion {
    @Override
    public void move() {
        System.out.println("풀파티 아리 이동");
    }

    @Override
    public void Q() {
        System.out.println("풀파티 아리 Q 사용");
    }

    @Override
    public void W() {
        System.out.println("풀파티 아리 W 사용");
    }

    @Override
    public void E() {
        System.out.println("풀파티 아리 E 사용");
    }

    @Override
    public void R() {
        System.out.println("풀파티 아리 R 사용");
    }
}
