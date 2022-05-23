package com.study.designpatterns.seungchan_moon._11_flyweight.after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private Map<String, Font> cache = new HashMap<>();

    public Font getFont(String font) {
        if (cache.containsKey(font)) {
            return cache.get(font);
        } else {
            String[] split = font.split(":");
            return new Font(split[0], Integer.parseInt(split[1]));
        }
    }
}
