package com.study.designpatterns.geunho_hong._15_interpreter._02_after;

import java.util.Map;

public interface PostfixExpression {

    int interpret(Map<Character, Integer> context);

}
