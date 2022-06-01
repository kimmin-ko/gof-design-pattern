package com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before;

public class Client {

    public static void main(String[] args) {
        Request request = new Request("무궁화 꽃이 피었습니다.");

        RequestHandler requestHandler = new AuthRequestHandler();
        requestHandler.handle(request);
    }
}
