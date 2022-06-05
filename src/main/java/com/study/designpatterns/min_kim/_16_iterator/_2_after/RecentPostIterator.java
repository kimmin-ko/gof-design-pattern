package com.study.designpatterns.min_kim._16_iterator._2_after;

import com.study.designpatterns.min_kim._16_iterator._1_before.Post;

import java.util.Iterator;
import java.util.List;

public class RecentPostIterator implements Iterator<Post> {

    private final Iterator<Post> internalIterator;

    public RecentPostIterator(List<Post> posts) {
        posts.sort((p1, p2) -> p2.getCreateDateTime().compareTo(p1.getCreateDateTime()));
        this.internalIterator = posts.iterator();
    }

    @Override
    public boolean hasNext() {
        return internalIterator.hasNext();
    }

    @Override
    public Post next() {
        return internalIterator.next();
    }
}
