package com.study.designpatterns.hyeongseok_choi._22_template._02_after;

public class Plus implements Operator {
    @Override
    public int getResult(int result, int number) {
        return result += number;
    }
}
