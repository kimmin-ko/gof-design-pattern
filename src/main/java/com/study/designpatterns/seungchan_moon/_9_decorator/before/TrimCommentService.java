package com.study.designpatterns.seungchan_moon._9_decorator.before;

public class TrimCommentService extends CommentService {

    @Override
    public void addComment(String comment) {
        super.addComment(trim(comment));
    }

    private String trim(String comment) {
        return comment.replace("...", "");
    }

}
