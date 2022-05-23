package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after;

import com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after.RequestHandler;
import com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.before.Request;

public class LoggingRequestHandler extends RequestHandler {
    public LoggingRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println("로깅");
        super.handler(request);
    }
}
