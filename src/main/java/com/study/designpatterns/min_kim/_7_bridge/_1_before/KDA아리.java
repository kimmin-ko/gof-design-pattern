package com.study.designpatterns.min_kim._7_bridge._1_before;

public class KDA아리 implements Champion {
    @Override
    public void move() {
        System.out.println("KDA 아리 이동");
    }

    @Override
    public void Q() {
        System.out.println("KDA 아리 Q 사용");
    }

    @Override
    public void W() {
        System.out.println("KDA 아리 W 사용");
    }

    @Override
    public void E() {
        System.out.println("KDA 아리 E 사용");
    }

    @Override
    public void R() {
        System.out.println("KDA 아리 R 사용");
    }
}
