package com.study.designpatterns.min_kim._11_flyweight._2_after;

import lombok.Getter;

@Getter
public final class Font {
    private final String fontFamily;
    private final int fontSize;

    public Font(String fontFamily, int fontSize) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }
}
