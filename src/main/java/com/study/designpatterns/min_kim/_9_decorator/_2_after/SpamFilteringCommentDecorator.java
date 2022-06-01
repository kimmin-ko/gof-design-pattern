package com.study.designpatterns.min_kim._9_decorator._2_after;

public class SpamFilteringCommentDecorator extends CommentDecorator {

    public SpamFilteringCommentDecorator(CommentService commentService) {
        super(commentService);
    }

    @Override
    public void addComment(String comment) {
        if (isSpam(comment)) {
            return;
        }

        super.addComment(comment);
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
