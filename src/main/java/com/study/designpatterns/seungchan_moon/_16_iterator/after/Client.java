package com.study.designpatterns.seungchan_moon._16_iterator.after;

import com.study.designpatterns.seungchan_moon._16_iterator.before.Post;

import java.util.Iterator;


public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("디자인 패턴");
        board.addPost("선생님, 저랑 디자인 패턴 하나 학습하시겠습니꽈?");
        board.addPost("지금 이 자리에 계신 여러분들은 모두 디자인 패턴을 학습하고 계신 분들입니닷");

        Iterator<Post> recentPostIterator = board.getRecentPostIterator();
        while (recentPostIterator.hasNext()) {
            System.out.println(recentPostIterator.next().getContent());
        }
    }
}
