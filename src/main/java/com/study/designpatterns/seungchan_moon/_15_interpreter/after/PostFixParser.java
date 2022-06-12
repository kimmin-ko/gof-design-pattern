package com.study.designpatterns.seungchan_moon._15_interpreter.after;

import com.study.designpatterns.seungchan_moon._13_chain_of_responsibility.after.MultiplyExpression;

import java.util.Stack;

import static com.study.designpatterns.seungchan_moon._15_interpreter.after.PostfixExpression.*;

public class PostFixParser {


    // TODO xyz+-
    public static PostfixExpression parse(String expression) {
        Stack<PostfixExpression> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            //stack.push(getExpression(c, stack));
            stack.push(getStaticExpression(c, stack));
        }
        return stack.pop();
    }

    private static PostfixExpression getExpression(char c, Stack<PostfixExpression> stack) {
        switch (c) {
            case '+':
                return new PlusExpression(stack.pop(), stack.pop());
            case '-':
                PostfixExpression right = stack.pop();
                PostfixExpression left = stack.pop();
                return new MinusExpression(left, right);
            case '*':
                return new MultiplyExpression(stack.pop(), stack.pop());
            default:
                return new VariableExpression(c);
        }
    }

    private static PostfixExpression getStaticExpression(char c, Stack<PostfixExpression> stack) {
        switch (c) {
            case '+':
                return plus(stack.pop(), stack.pop());
            case '-':
                PostfixExpression right = stack.pop();
                PostfixExpression left = stack.pop();
                return minus(left, right);
            case '*':
                return multiply(stack.pop(), stack.pop());
            default:
                return variable(c);
        }
    }
}
