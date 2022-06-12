package com.study.designpatterns.seungchan_moon._16_iterator.after;

import com.study.designpatterns.seungchan_moon._16_iterator.before.Post;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecentPostIterator implements Iterator<Post> {

    private Iterator<Post> internalIterator;

    private Board board;

    public RecentPostIterator(Board board) {
        List<Post> posts = board.getPosts();
        Collections.sort(posts, (p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()));
        this.internalIterator = posts.listIterator();
    }

    @Override
    public boolean hasNext() {
        return this.internalIterator.hasNext();
    }

    @Override
    public Post next() {
        return this.internalIterator.next();
    }
}
