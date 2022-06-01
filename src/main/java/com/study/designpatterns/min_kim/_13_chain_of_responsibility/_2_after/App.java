package com.study.designpatterns.min_kim._13_chain_of_responsibility._2_after;

public class App {

    public static void main(String[] args) {
        RequestHandler requestHandler = new AuthRequestHandler(new LoggingRequestHandler(new PrintRequestHandler(null)));

        Client client = new Client(requestHandler);
        client.doWork();
    }
}
