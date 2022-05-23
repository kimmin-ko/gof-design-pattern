package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.before;

public class Client {

    public static void main(String[] args) {
        Request request = new Request("무궁화 꽃이 피었습니다.");
        RequestHandler authRequestHandler = new AuthRequestHandler();
        authRequestHandler.handler(request);

        RequestHandler loggingRequestHandler = new LoggingRequestHandler();
        loggingRequestHandler.handler(request);

        // 클라이언트가 코드가 바뀐다.
        // 같이 하고 싶을 땐?
    }
}
