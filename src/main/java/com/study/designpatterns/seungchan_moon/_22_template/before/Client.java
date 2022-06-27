package com.study.designpatterns.seungchan_moon._22_template.before;

public class Client {
    public static void main(String[] args) {
//        FileProcessor fileProcessor = new FileProcessor("number.txt");
//        int result = fileProcessor.process();
//        System.out.println("result = " + result);

        MultiplyFileProcessor multiplyFileProcessor = new MultiplyFileProcessor("number.txt");
        int multiplyResult = multiplyFileProcessor.process();
        System.out.println("multiplyResult = " + multiplyResult);
    }
}
