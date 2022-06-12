package com.study.designpatterns.seungchan_moon._9_decorator.before;

public class Client {

    private CommentService commentService;



    // 상속으로 해결할 때 생기는 문제
    private static boolean enabledSpamFilter = true;
    private static boolean enabledTrimming = true;

    public Client(CommentService commentService) {
        this.commentService = commentService;
    }

    private void writeComment(String comment) {
        commentService.addComment(comment);
    }

    public static void main(String[] args) {
        CommentService commentService = new CommentService();
        if (enabledSpamFilter) {
            commentService = new SpamFilteringCommentService();
        }
        if (enabledTrimming) {
            commentService = new TrimCommentService();
        }
        if (enabledTrimming && enabledSpamFilter) {
            // ???
        }

        Client client = new Client(new TrimCommentService());
        client.writeComment("오징어 게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://www.naver.com");

        Client filterClient = new Client(new SpamFilteringCommentService());
        filterClient.writeComment("오징어 게임");
        filterClient.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        filterClient.writeComment("http://www.naver.com");
    }
}
