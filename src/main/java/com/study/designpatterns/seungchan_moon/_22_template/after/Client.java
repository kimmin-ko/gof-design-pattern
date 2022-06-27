package com.study.designpatterns.seungchan_moon._22_template.after;

public class Client {
    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor("number.txt");
//        int result = plus.process(new Operator() {
//            @Override
//            public int getResult(int result, int number) {
//                return result += number;
//            }
//        });
        int result = fileProcessor.process((result1, number) -> result1 += number);
        System.out.println("result = " + result);

        int result2 = fileProcessor.process(new Multiply());
        System.out.println("result2 = " + result2);
    }

    static class Multiply implements Operator {

        @Override
        public int getResult(int result, int number) {
            return result *= number;
        }
    }
}
