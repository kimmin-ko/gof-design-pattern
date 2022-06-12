package com.study.designpatterns.min_kim._15_interpreter._2_after;

import java.util.Map;

public class App {

    public static void main(String[] args) {
        PostfixExpression expression = PosfixParser.parse("xyz+-");
        int result = expression.interpret(Map.of('x', 1, 'y', 2, 'z', 3));
        System.out.println("result = " + result);
    }
}
