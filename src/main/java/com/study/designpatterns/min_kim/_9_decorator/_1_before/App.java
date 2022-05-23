package com.study.designpatterns.min_kim._9_decorator._1_before;

public class App {

    public static void main(String[] args) {
        Client client = new Client(new TrimmingCommentService());

        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거 보다 재밌을 수 없지...");
        client.writeComment("http://whiteship.me");
    }
}
