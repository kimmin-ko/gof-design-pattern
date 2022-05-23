package com.study.designpatterns.min_kim._9_decorator._3_java;

import javax.servlet.http.HttpServletRequestWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecoratorInJava {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(new Book());

        List books = Collections.checkedList(list, Book.class);
        books.add(new Item()); // java.lang.ClassCastException 발생 !!
    }

    private static class Book {

    }

    private static class Item {

    }
}
