package com.study.designpatterns.seungchan_moon._8_decorator.before;

public class SpamFilteringCommentService extends CommentService {

    @Override
    public void addComment(String comment) {
        boolean spam = isSpam(comment);
        if (!spam) {
            super.addComment(comment);
        }
    }

    private boolean isSpam(String comment) {
        return comment.contains("http");
    }
}
