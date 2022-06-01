package com.study.designpatterns.min_kim._13_chain_of_responsibility._2_after;

import com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before.Request;

public class LoggingRequestHandler extends RequestHandler {
    
    public LoggingRequestHandler(RequestHandler chain) {
        super(chain);
    }

    @Override
    public void handle(Request request) {
        System.out.println("로깅");
        super.handle(request);
    }
}
