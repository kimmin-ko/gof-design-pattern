package com.study.designpatterns.min_kim._20_state._2_after;

public class Client {

    public static void main(String[] args) {
        OnlineCourse onlineCourse = new OnlineCourse();

        Student min = new Student("min");
        Student su = new Student("su");

        onlineCourse.addStudent(min);
        onlineCourse.addReview("hello", min);


        System.out.println(onlineCourse);
    }
}
