package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after;

import com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after.RequestHandler;
import com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.before.Request;

public class AuthRequestHandler extends RequestHandler {

    public AuthRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println("인증이 됐니?");
        super.handler(request);
    }
}
