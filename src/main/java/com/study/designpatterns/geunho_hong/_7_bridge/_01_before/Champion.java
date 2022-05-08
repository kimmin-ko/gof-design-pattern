package com.study.designpatterns.geunho_hong._7_bridge._01_before;

import me.whiteship.designpatterns._02_structural_patterns._07_bridge._02_after.Skin;

public interface Champion extends Skin {

    void move();

    void skillQ();

    void skillW();

    void skillE();

    void skillR();

}
