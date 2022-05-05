package com.study.designpatterns.seungchan_moon._6_adapter.java;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

public class AdapterSpring {
    public static void main(String[] args) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        HandlerAdapter handler = new RequestMappingHandlerAdapter();
    }
}
