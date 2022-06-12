package com.study.designpatterns.seungchan_moon._15_interpreter.java;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;


public class InterpreterInSpring {

    public static void main(String[] args) {
        Book book = new Book("Spring");
        ExpressionParser parse = new SpelExpressionParser();
        Expression expression = parse.parseExpression("title");
        System.out.println(expression.getValue(book));
    }
}
