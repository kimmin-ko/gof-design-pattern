package com.study.designpatterns.seungchan_moon._16_iterator.before;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// 애그리거트에 해당한다.
public class Board {
    private List<Post> posts = new ArrayList<>();

    public Board(List<Post> posts) {
        this.posts = posts;
    }

    public Board() {

    }

    public void addPost(String post) {
        posts.add(new Post(post));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public Iterator<Post> getDefaultIterator() {
        return posts.iterator();
    }
}
