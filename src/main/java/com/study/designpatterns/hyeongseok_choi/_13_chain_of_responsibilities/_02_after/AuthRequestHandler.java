package com.study.designpatterns.hyeongseok_choi._13_chain_of_responsibilities._02_after;

import com.study.designpatterns.hyeongseok_choi._13_chain_of_responsibilities._01_before.Request;

public class AuthRequestHandler extends RequestHandler {

    public AuthRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handle(Request request) {
        System.out.println("인증이 되었는가?");
        super.handle(request);
    }
}
