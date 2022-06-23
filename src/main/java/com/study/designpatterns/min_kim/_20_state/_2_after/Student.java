package com.study.designpatterns.min_kim._20_state._2_after;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private String name;

    private final Set<OnlineCourse> onlineCourses = new HashSet<>();

    public Student(String name) {
        this.name = name;
    }

    public void addPrivateCourse(OnlineCourse onlineCourse) {
        this.onlineCourses.add(onlineCourse);
    }

    public boolean isAvailable(OnlineCourse onlineCourse) {
        return this.onlineCourses.contains(onlineCourse);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
