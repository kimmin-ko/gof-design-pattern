package com.study.designpatterns.seungchan_moon._6_adapter.java;

import java.io.*;
import java.util.*;

public class AdapterInJava {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("A", "B", "C");
        Enumeration<String> enumeration = Collections.enumeration(strings);
        ArrayList<String> list = Collections.list(enumeration);

        try (InputStream is = new FileInputStream("input.txt");
             InputStreamReader isr = new InputStreamReader(is);
             BufferedReader reader = new BufferedReader(isr)) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
