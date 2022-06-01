package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after;

import com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.before.Request;

public abstract class RequestHandler {
    private RequestHandler nextHandler;

    public RequestHandler(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handler(Request request) {
        if(nextHandler != null) {
            nextHandler.handler(request);
        }
    }


}
