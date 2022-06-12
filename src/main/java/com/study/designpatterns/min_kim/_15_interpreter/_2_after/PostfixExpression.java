package com.study.designpatterns.min_kim._15_interpreter._2_after;

import java.util.Map;

public interface PostfixExpression {

    int interpret(Map<Character, Integer> context);

}
