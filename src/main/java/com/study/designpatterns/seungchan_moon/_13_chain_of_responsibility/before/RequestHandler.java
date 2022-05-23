package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.before;

public class RequestHandler {
    public void handler(Request request) {

        System.out.println(request.getBody());
    }
}
