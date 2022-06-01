package com.study.designpatterns.min_kim._13_chain_of_responsibility._2_after;

import com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before.Request;

import java.util.Objects;

public abstract class RequestHandler {

    private final RequestHandler chain;

    RequestHandler(RequestHandler chain) {
        this.chain = chain;
    }

    public void handle(Request request) {
        if (Objects.isNull(this.chain)) {
            return;
        }

        this.chain.handle(request);
    }
}
