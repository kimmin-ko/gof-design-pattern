package com.study.designpatterns.seungchan_moon._12_proxy.before;

import com.study.designpatterns.seungchan_moon._12_proxy.before.GameService;

public class GameServiceProxy extends GameService {
    @Override
    public void start() {
        long before = System.currentTimeMillis();
        super.start();
        long after = System.currentTimeMillis();
        System.out.println(after - before);
    }
}
