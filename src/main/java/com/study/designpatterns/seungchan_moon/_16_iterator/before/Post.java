package com.study.designpatterns.seungchan_moon._16_iterator.before;

import java.time.LocalDateTime;

public class Post {
    private String content;
    private LocalDateTime createdAt;

    public Post(String content) {
        this.content = content;
        createdAt = LocalDateTime.now();
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
