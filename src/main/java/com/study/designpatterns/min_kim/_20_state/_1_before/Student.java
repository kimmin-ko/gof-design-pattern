package com.study.designpatterns.min_kim._20_state._1_before;

import java.util.Set;

public class Student {

    private String name;

    private Set<OnlineCourse> onlineCourses;

    public Student(String name) {
        this.name = name;
    }

    public void addPrivateCourse(OnlineCourse onlineCourse) {

    }

    public boolean isAvailable(OnlineCourse onlineCourse) {
        return this.onlineCourses.contains(onlineCourse);
    }
}
