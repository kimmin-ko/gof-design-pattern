package com.study.designpatterns.min_kim._13_chain_of_responsibility._2_after;

import com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before.Request;

public class Client {

    private final RequestHandler requestHandler;

    public Client(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    public void doWork() {
        Request request = new Request("이번 놀이는 뽑기입니다.");
        requestHandler.handle(request);
    }
}
