package com.study.designpatterns.seungchan_moon._20_state.before;

public class Client {
    public static void main(String[] args) {
        Student moon = new Student("moon");
        OnlineCourse onlineCourse = new OnlineCourse();

//        Student lee = new Student("lee");
//        lee.addPrivateCourse(onlineCourse);
//
        onlineCourse.addStudent(moon);
//        onlineCourse.changeState(OnlineCourse.State.PRIVATE);
//
//        onlineCourse.addStudent(lee);
//        onlineCourse.addReview("hello", moon);

        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getStudents());
        System.out.println(onlineCourse.getReviews());

    }
}
