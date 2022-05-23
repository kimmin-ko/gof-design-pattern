package com.study.designpatterns.seungchan_moon._12_proxy.java;

import com.study.designpatterns.seungchan_moon._12_proxy.after.DefaultGameService;
import com.study.designpatterns.seungchan_moon._12_proxy.after.GameService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInJava {
    public static void main(String[] args) {
        ProxyInJava proxyInJava = new ProxyInJava();
        proxyInJava.dynamicProxy();
    }

    private void dynamicProxy() {
        GameService gameServiceProxy = getGameServiceProxy(new DefaultGameService());
        gameServiceProxy.start();
    }

    private GameService getGameServiceProxy(DefaultGameService target) {
        return (GameService) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{GameService.class}, (new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Hello dynamic proxy");
                        method.invoke(target, args);
                        return null;
                    }
                }));
    }
}
