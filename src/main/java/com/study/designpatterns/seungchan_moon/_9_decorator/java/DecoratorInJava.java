package com.study.designpatterns.seungchan_moon._9_decorator.java;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DecoratorInJava {
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add(new Book());

        List books = Collections.checkedList(list, Book.class);
        list.add(new Item());
        books.add(new Item());


        // HttpServletRequestWrapper requestWrapper;
        // HttpServletReponseWrapper reponseWrapper;
    }
}
