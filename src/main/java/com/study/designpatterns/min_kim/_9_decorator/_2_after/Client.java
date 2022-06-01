package com.study.designpatterns.min_kim._9_decorator._2_after;

public class Client {

    private final CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;

    }

    public void writeComment(String comment) {
        commentService.addComment(comment);
    }
}
