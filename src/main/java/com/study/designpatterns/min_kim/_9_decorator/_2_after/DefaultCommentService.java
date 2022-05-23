package com.study.designpatterns.min_kim._9_decorator._2_after;

public class DefaultCommentService implements CommentService {

    @Override
    public void addComment(String comment) {
        System.out.println(comment);
    }
}
