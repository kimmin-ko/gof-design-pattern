package com.study.designpatterns.min_kim._21_strategy._3_java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StrategyInJava {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(10);
        numbers.add(7);

        numbers.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(numbers);

        numbers.sort(Comparator.reverseOrder());
        System.out.println(numbers);

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
