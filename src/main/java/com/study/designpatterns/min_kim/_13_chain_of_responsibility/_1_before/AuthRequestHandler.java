package com.study.designpatterns.min_kim._13_chain_of_responsibility._1_before;

public class AuthRequestHandler extends RequestHandler {

    @Override
    public void handle(Request request) {
        System.out.println("[인증] 사용자가 해당 서비스에 접근할 권한이 있는가?");
        System.out.println("[인가] 인증된 사용자가 해당 요청을 처리할 권한이 있는가?");
        super.handle(request);
    }
}
