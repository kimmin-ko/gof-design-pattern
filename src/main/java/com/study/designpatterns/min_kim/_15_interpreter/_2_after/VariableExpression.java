package com.study.designpatterns.min_kim._15_interpreter._2_after;

import java.util.Map;

public class VariableExpression implements PostfixExpression {

    private final Character variable;

    public VariableExpression(Character variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return context.get(variable);
    }
}
