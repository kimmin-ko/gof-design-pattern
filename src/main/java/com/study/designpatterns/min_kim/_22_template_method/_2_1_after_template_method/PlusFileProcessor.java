package com.study.designpatterns.min_kim._22_template_method._2_1_after_template_method;

public class PlusFileProcessor extends FileProcessor {

    public PlusFileProcessor(String path) {
        super(path);
    }

    @Override
    protected int getResult(int result, int value) {
        return result + value;
    }
}
