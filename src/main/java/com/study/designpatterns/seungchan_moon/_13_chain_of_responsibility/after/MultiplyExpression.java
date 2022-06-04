package com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after;

import com.study.designpatterns.seungchan_moon._15_interpreter.after.PostfixExpression;

import java.util.Map;

public class MultiplyExpression implements PostfixExpression {

    private PostfixExpression left, right;

    public MultiplyExpression(PostfixExpression left, PostfixExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return left.interpret(context) * right.interpret(context);
    }
}
