package com.study.designpatterns.seungchan_moon._8_decorator.after;

public class DefaultCommentService implements CommentService{

    @Override
    public void addComment(String comment) {
        System.out.println(comment);
    }
}
