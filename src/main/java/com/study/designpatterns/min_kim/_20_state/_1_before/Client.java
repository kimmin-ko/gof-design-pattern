package com.study.designpatterns.min_kim._20_state._1_before;

public class Client {

    public static void main(String[] args) {
        Student student1 = new Student("minkim");
        OnlineCourse onlineCourse = new OnlineCourse();

        Student student2 = new Student("keesun");
        student2.addPrivateCourse(onlineCourse);

        onlineCourse.addStudent(student1);
        onlineCourse.changeState(OnlineCourse.State.PRIVATE);

        onlineCourse.addStudent(student2);

        onlineCourse.addReview("hello", student1);

        System.out.println(onlineCourse.getState());
        System.out.println(onlineCourse.getStudents());
        System.out.println(onlineCourse.getReviews());
    }
}
