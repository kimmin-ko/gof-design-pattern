package com.study.designpatterns.min_kim._16_iterator._2_after;

import com.study.designpatterns.min_kim._16_iterator._1_before.Board;
import com.study.designpatterns.min_kim._16_iterator._1_before.Post;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Client {

    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("디자인 패턴 게임");
        board.addPost("선생님, 저랑 디자인 패턴 하나 학습하시겠습니까?");
        board.addPost("지금 이 자리에 계신 여러분은 모두 디자인 패턴을 학습하고 계신 분들입니다.");

        // TODO 들어간 순서대로 순회하기
        Iterator<Post> iterator = board.getDefaultIterator();
        iterator.forEachRemaining(post -> System.out.println(post.getTitle()));

        // TODO 가장 최신 글 먼저 순회하기
        Iterator<Post> recentPostIterator = board.getRecentPostIterator();
        recentPostIterator.forEachRemaining(post -> System.out.println(post.getTitle()));
    }
}
