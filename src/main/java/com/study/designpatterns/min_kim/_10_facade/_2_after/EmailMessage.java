package com.study.designpatterns.min_kim._10_facade._2_after;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailMessage {
    private String from;
    private String to;
    private String subject;
    private String text;
}
