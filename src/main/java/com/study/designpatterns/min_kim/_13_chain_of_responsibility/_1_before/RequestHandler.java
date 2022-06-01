package com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before;

public class RequestHandler {

    public void handle(Request request) {
        System.out.println(request.getBody());
    }
}
