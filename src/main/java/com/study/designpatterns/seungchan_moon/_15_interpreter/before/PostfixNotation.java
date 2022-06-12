package com.study.designpatterns.seungchan_moon._15_interpreter.before;

import java.util.Stack;

// TODO 산수로 계산을 할 때 기호(부호)가 가운데 들어가는 형태를 인픽스라 부른다. 앞에 오면 prefix, 뒤에 오면 postfix 이다.
public class PostfixNotation {

    private final String expression;

    public PostfixNotation(String expression) {
        this.expression = expression;
    }

    public static void main(String[] args) {
        PostfixNotation postfixNotation = new PostfixNotation("123+-");
        postfixNotation.calculate();
    }

    private void calculate() {
        Stack<Integer> numbers = new Stack<>();

        for (char c : this.expression.toCharArray()) {
            switch (c) {
                case '+':
                    numbers.push(numbers.pop() + numbers.pop());
                    break;
                case '-':
                    int right = numbers.pop();
                    int left = numbers.pop();
                    numbers.push(left - right);
                    break;
                default:
                    numbers.push(Integer.parseInt(c + ""));
            }
        }
        System.out.println(numbers.pop());
    }
}
