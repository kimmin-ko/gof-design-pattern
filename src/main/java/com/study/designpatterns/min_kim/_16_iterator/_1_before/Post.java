package com.study.designpatterns.min_kim._16_iterator._1_before;

import java.time.LocalDateTime;

public class Post {

    private final String title;

    private final LocalDateTime createDateTime;

    public Post(String title) {
        this.title = title;
        this.createDateTime = LocalDateTime.now();
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDateTime getCreateDateTime() {
        return this.createDateTime;
    }

}
