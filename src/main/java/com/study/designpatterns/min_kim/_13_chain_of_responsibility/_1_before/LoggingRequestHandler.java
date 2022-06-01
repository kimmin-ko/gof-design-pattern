package com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before;

public class LoggingRequestHandler extends RequestHandler {

    @Override
    public void handle(Request request) {
        System.out.println("로깅");
        super.handle(request);
    }
}
