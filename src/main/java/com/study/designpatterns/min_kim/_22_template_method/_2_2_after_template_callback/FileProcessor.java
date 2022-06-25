package com.study.designpatterns.min_kim._22_template_method._2_2_after_template_callback;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {

    private String path;

    protected FileProcessor(String path) {
        this.path = path;
    }

    public int process(Operator operator) {
        try (BufferedReader br = new BufferedReader(new FileReader(this.path))) {
            int result = 0;
            String line;
            while ((line = br.readLine()) != null) {
                result = operator.getResult(result, Integer.parseInt(line));
            }
            return result;
        } catch (IOException e) {
            throw new IllegalArgumentException(this.path + "에 해당하는 파일이 없습니다.");
        }
    }
}
