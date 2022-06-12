package com.study.designpatterns.seungchan_moon._15_interpreter.after;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        // parser 와 expression 을 만들고..
        PostfixExpression expression = PostFixParser.parse("xyz+-a*");
        Map<Character, Integer> context = Map.of('x', 1, 'y', 2, 'z', 3, 'a', 4);

        // 인터프리트 할 때 컨텍스트를 준다.
        int result = expression.interpret(context);
        System.out.println(result);
    }
}
