package com.study.designpatterns.geunho_hong._7_bridge._01_before;

import com.study.designpatterns.geunho_hong._7_bridge._02_after.Skin;

public interface Champion extends Skin {

    void move();

    void skillQ();

    void skillW();

    void skillE();

    void skillR();

}
