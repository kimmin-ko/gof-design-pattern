package com.study.designpatterns.min_kim._10_facade._2_after;

import lombok.Getter;

@Getter
public class EmailSettings {

    private String host;

    public EmailSettings(String host) {
        this.host = host;
    }
}
