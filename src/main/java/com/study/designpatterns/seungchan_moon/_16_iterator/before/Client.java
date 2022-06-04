package com.study.designpatterns.seungchan_moon._16_iterator.before;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Board board = new Board();
        board.addPost("디자인 패턴");
        board.addPost("선생님, 저랑 디자인 패턴 하나 학습하시겠습니꽈?");
        board.addPost("지금 이 자리에 계신 여러분들은 모두 디자인 패턴을 학습하고 계신 분들입니닷");

        // TODO 들어간 순서대로 순회하기
        // 클라이언트 코드가 서버 코드를 알게 된다. >>> List<Post> posts 가 배열이나 다른 컬렉션으로 수정되면 영향을 받음
        List<Post> posts = board.getPosts();
        Iterator<Post> iterator = posts.iterator();
        System.out.println(iterator.getClass());
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println(post.getContent());
        }

        // Iterator<Post> concreteAggregateIterator = board.getPosts().iterator();
        Iterator<Post> concreteAggregateIterator = board.getDefaultIterator();
        while (concreteAggregateIterator.hasNext()) {
            System.out.println(concreteAggregateIterator.next().getContent());
        }

        // TODO 가장 최신 콘텐츠 먼저 순회하기
        Collections.sort(posts, (p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));
        for (int i = 0; i < posts.size(); i++) {
            Post post = posts.get(i);
            System.out.println(post.getContent());
        }
    }
}
