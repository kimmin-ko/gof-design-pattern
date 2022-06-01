package com.study.designpatterns.min_kim._12_proxy._3_java;

import com.study.designpatterns.min_kim._12_proxy._2_after.DefaultGameService;
import com.study.designpatterns.min_kim._12_proxy._2_after.GameService;

import java.lang.reflect.Proxy;

public class ProxyInJava {

    public static void main(String[] args) {
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();
    }

    private void dynamicProxy() {
        GameService gameService = getGameServiceProxy(new DefaultGameService());
        gameService.startGame();
    }

    private GameService getGameServiceProxy(GameService target) {
        return (GameService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{GameService.class},
                (proxy, method, args) -> {
                    System.out.println("--before--");
                    method.invoke(target, args);
                    System.out.println("--after--");
                    return null;
                });
    }
}
