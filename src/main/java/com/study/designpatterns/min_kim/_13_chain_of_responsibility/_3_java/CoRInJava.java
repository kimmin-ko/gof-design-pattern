package com.study.designpatterns.min_kim._13_chain_of_responsibility._3_java;

import javax.servlet.*;
import java.io.IOException;

public class CoRInJava {

    public static void main(String[] args) {
        Filter filter = new Filter() {
            @Override
            public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
                // 전처리
                chain.doFilter(request, response);
                // 후처리
            }
        };
    }
}
