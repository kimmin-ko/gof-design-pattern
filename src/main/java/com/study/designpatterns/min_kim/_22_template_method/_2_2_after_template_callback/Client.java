package com.study.designpatterns.min_kim._22_template_method._2_2_after_template_callback;

public class Client {

    public static void main(String[] args) {
        String path = "src/main/java/com/study/designpatterns/min_kim/_22_template_method/number.txt";
        int result = 0;

        FileProcessor plusFileProcessor = new FileProcessor(path);
        result = plusFileProcessor.process(new PlusOperator());
        System.out.println(result);

        FileProcessor multiplyFileProcessor = new FileProcessor(path);
        result = multiplyFileProcessor.process((r, v) -> (r != 0 ? r : 1) * v);
        System.out.println(result);
    }
}