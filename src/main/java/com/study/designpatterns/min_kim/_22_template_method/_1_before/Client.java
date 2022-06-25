package com.study.designpatterns.min_kim._22_template_method._1_before;

public class Client {

    public static void main(String[] args) {
        String path = "src/main/java/com/study/designpatterns/min_kim/_22_template_method/number.txt";

        FileProcessor fileProcessor = new FileProcessor(path);
        int result = fileProcessor.process();
        System.out.println(result);
    }
}