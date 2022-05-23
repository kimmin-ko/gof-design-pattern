package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after;

import com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.before.Request;

public class PrintRequestHandler extends RequestHandler{

    public PrintRequestHandler(RequestHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void handler(Request request) {
        System.out.println(request.getBody());
        super.handler(request);
    }
}
