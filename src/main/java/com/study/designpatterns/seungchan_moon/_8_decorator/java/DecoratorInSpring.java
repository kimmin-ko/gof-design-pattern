package com.study.designpatterns.seungchan_moon._8_decorator.java;

import org.springframework.beans.factory.xml.BeanDefinitionDecorator;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
import org.springframework.web.server.WebFilter;

public class DecoratorInSpring {

    BeanDefinitionDecorator definitionDecorator;

    ServerHttpRequestDecorator httpRequestDecorator;
    ServerHttpResponseDecorator httpResponseDecorator;

    WebFilter webFilter;
}
