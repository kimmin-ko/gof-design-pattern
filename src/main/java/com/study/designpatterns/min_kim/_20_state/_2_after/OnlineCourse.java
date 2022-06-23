package com.study.designpatterns.min_kim._20_state._2_after;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourse {

    private State state;

    private final List<Student> students = new ArrayList<>();

    private final List<String> reviews = new ArrayList<>();

    public OnlineCourse() {
        this.state = new Draft(this);
    }

    public void addStudent(Student student) {
        this.state.addStudent(student);
    }

    public void addReview(String review, Student student) {
        this.state.addReview(review, student);
    }

    public void changeState(State state) {
        this.state = state;
    }

    public boolean contains(Student student) {
        return this.students.contains(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<String> getReviews() {
        return reviews;
    }

    @Override
    public String toString() {
        return "OnlineCourse{" +
                "state=" + state +
                ", students=" + students +
                ", reviews=" + reviews +
                '}';
    }
}
