package com.study.designpatterns.min_kim._6_adapter.java;

import java.io.*;

public class AdapterInJava {

    public static void main(String[] args) {
        // target -> List<String>
        // adapter -> Arrays.asList()
        // adaptee -> String[]
//        String[] adaptee = {"a", "b", "c"};
//        List<String> target = Arrays.asList(adaptee);

        try (InputStream is = new FileInputStream("input.txt");
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr)) {

            while (br.ready()) {
                System.out.println(br.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
