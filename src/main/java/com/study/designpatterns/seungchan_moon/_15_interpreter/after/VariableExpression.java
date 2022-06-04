package com.study.designpatterns.seungchan_moon._15_interpreter.after;

import java.util.Map;

//x, y, z 가 해당된다.
public class VariableExpression implements PostfixExpression{

    private Character variable;

    public VariableExpression(Character variable) {
        this.variable = variable;
    }

    @Override
    public int interpret(Map<Character, Integer> context) {
        return context.get(variable);
    }
}
