package com.study.designpatterns.min_kim._9_decorator._2_after;

public class App {

    private static final boolean ENABLED_TRIMMING = true;
    private static final boolean ENABLED_SPAM_FILTERING = true;

    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if (ENABLED_TRIMMING) {
            commentService = new TrimmingCommentDecorator(commentService);
        }

        if (ENABLED_SPAM_FILTERING) {
            commentService = new SpamFilteringCommentDecorator(commentService);
        }

        Client client = new Client(commentService);

        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거 보다 재밌을 수 없지...");
        client.writeComment("http://whiteship.me");
    }
}
