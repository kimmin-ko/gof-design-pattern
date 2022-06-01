package com.study.designpatterns.min_kim._13_chain_of_responsibility._2_after;

import com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before.Request;

public class AuthRequestHandler extends RequestHandler {

    public AuthRequestHandler(RequestHandler chain) {
        super(chain);
    }

    @Override
    public void handle(Request request) {
        System.out.println("인증");
        System.out.println("인가");
        super.handle(request);
    }
}
