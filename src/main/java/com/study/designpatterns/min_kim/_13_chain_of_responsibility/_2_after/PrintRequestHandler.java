package com.study.designpatterns.min_kim._13_chain_of_responsibility._2_after;

import com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before.Request;

public class PrintRequestHandler extends RequestHandler{

    public PrintRequestHandler(RequestHandler chain) {
        super(chain);
    }

    @Override
    public void handle(Request request) {
        System.out.println(request.getBody());
        super.handle(request);
    }
}
