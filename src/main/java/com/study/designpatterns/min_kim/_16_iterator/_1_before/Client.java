package com.study.designpatterns.min_kim._16_iterator._1_before;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("디자인 패턴 게임");
        board.addPost("선생님, 저랑 디자인 패턴 하나 학습하시겠습니까?");
        board.addPost("지금 이 자리에 계신 여러분은 모두 디자인 패턴을 학습하고 계신 분들입니다.");

        // TODO 들어간 순서대로 순회하기

        // 문제점
        // board의 posts 타입이 Set으로 변경되면 클라이언트 코드도 변경되어야 함.
        List<Post> posts = board.getPosts(); // List는 Aggregate 역할

        Iterator<Post> iterator = posts.iterator(); // Iterator는 Iterator 역할
        System.out.println(iterator.getClass().getName()); // ArrayList$Itr은 ConcreteIterator 역할

        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }

        // TODO 가장 최신 글 먼저 순회하기
        posts.sort((p1, p2) -> p2.getCreateDateTime().compareTo(p1.getCreateDateTime()));
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println(post.getTitle());
        }
    }
}
