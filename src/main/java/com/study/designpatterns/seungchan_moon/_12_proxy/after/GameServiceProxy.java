package com.study.designpatterns.seungchan_moon._12_proxy.after;

public class GameServiceProxy implements GameService {
    private GameService gameService;

    @Override
    public void start() {
        long before = System.currentTimeMillis();
        if (this.gameService == null) {
            this.gameService = new DefaultGameService();
        }
        gameService.start();
        System.out.println(System.currentTimeMillis() - before);
    }
}
