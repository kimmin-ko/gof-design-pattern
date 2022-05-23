package com.study.designpatterns.min_kim._9_decorator._1_before;

public class SpamFilteringCommentService extends CommentService{

    @Override
    public void addComment(String comment) {
        if (comment.contains("http")) {
            return;
        }

        super.addComment(comment);
    }
}
