package com.study.designpatterns.min_kim._22_template_method._2_1_after_template_method;

public class Client {

    public static void main(String[] args) {
        String path = "src/main/java/com/study/designpatterns/min_kim/_22_template_method/number.txt";
        int result;

        FileProcessor plusFileProcessor = new PlusFileProcessor(path);
        result = plusFileProcessor.process();
        System.out.println(result);

        FileProcessor multiplyFileProcessor = new MultiplyFileProcessor(path);
        result = multiplyFileProcessor.process();
        System.out.println(result);
    }
}