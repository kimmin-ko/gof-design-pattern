package com.study.designpatterns.hyeongseok_choi._2_factorymethod._03_java;

import java.util.Calendar;
import java.util.Locale;

// 자바의 Calendar는 심플 팩토리 패턴으로 이루어져 있
public class CalendarExample {
    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().getClass()); // java.util.GregorianCalendar
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("th-TH-x-lvariant-TH")).getClass()); // sun.util.BuddhistCalender
        System.out.println(Calendar.getInstance(Locale.forLanguageTag("ja-JP-x-lvariant-JP")).getClass()); // java.util.JapaneseImperialCalender
    }
}
