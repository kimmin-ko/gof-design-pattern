package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.before;

public class AuthRequestHandler extends RequestHandler{
    public void handler(Request request) {
        System.out.println("인증이 됐니?");
        System.out.println("사용할 수 있니?");
        super.handler(request);
    }
}
