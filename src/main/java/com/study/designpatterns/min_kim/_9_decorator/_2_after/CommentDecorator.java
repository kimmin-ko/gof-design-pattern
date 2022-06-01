package com.study.designpatterns.min_kim._9_decorator._2_after;

public class CommentDecorator implements CommentService {

    private final CommentService commentService;

    public CommentDecorator(CommentService commentService) {
        this.commentService = commentService;
    }

    @Override
    public void addComment(String comment) {
        commentService.addComment(comment);
    }
}
