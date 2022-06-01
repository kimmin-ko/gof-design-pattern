package com.study.designpatterns.seungchan_moon._9_decorator.after;

public class DefaultCommentService implements CommentService{

    @Override
    public void addComment(String comment) {
        System.out.println(comment);
    }
}
