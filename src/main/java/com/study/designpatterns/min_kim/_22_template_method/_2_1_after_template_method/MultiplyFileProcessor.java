package com.study.designpatterns.min_kim._22_template_method._2_1_after_template_method;

public class MultiplyFileProcessor extends FileProcessor {

    public MultiplyFileProcessor(String path) {
        super(path);
    }

    @Override
    protected int getResult(int result, int value) {
        if (result == 0) {
            result = 1;
        }
        return result * value;
    }
}
