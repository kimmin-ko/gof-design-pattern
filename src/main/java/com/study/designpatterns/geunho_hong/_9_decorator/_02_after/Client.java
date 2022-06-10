package com.study.designpatterns.geunho_hong._9_decorator._02_after;

public class Client {

    private CommentService commentService;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    public void writeComment(String comment) {
        commentService.addComment(comment);
    }
}
