package com.study.designpatterns.geunho_hong._22_template._02_after;

public class Plus implements Operator {
    @Override
    public int getResult(int result, int number) {
        return result += number;
    }
}
