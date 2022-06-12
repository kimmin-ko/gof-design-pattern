package com.study.designpatterns.seungchan_moon._15_interpreter.after;

import java.util.Map;

//x, y, z 가 해당된다.
public class MinusExpression implements PostfixExpression{

    private PostfixExpression left;
    private PostfixExpression right;

    public MinusExpression(PostfixExpression left, PostfixExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return left.interpret(context) - right.interpret(context);
    }
}
