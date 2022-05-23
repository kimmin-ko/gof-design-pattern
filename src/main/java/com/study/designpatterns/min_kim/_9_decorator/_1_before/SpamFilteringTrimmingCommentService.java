package com.study.designpatterns.min_kim._9_decorator._1_before;

public class SpamFilteringTrimmingCommentService extends CommentService {

    @Override
    public void addComment(String comment) {
        if (comment.contains("http")) {
            return;
        }

        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }
}
