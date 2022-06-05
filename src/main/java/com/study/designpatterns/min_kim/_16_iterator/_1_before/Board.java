package com.study.designpatterns.min_kim._16_iterator._1_before;

import com.study.designpatterns.min_kim._16_iterator._2_after.RecentPostIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Board {

    private final List<Post> posts = new ArrayList<>();

    public void addPost(String content) {
        posts.add(new Post(content));
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Post> getPosts() {
        return this.posts;
    }

    public Iterator<Post> getDefaultIterator() {
        return this.posts.iterator();
    }

    public Iterator<Post> getRecentPostIterator() {
        return new RecentPostIterator(this.posts);
    }
}
