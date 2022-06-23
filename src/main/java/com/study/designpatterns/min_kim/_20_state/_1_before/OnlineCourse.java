package com.study.designpatterns.min_kim._20_state._1_before;

import java.util.ArrayList;
import java.util.List;

public class OnlineCourse {

    private State state;

    private final List<Student> students = new ArrayList<>();

    private final List<String> reviews = new ArrayList<>();

    public void addStudent(Student student) {
        if (this.state.equals(State.DRAFT) || this.state.equals(State.PUBLISHED)) {
            this.students.add(student);
        } else if (this.state.equals(State.PRIVATE) && student.isAvailable(this)) {
            this.students.add(student);
        } else {
            throw new UnsupportedOperationException("학생을 해당 수업에 추가할 수 없습니다.");
        }

        if (this.students.size() > 1) {
            this.state = State.PRIVATE;
        }
    }

    public void changeState(State state) {
        this.state = state;
    }

    public void addReview(String review, Student student) {
        if (this.state.equals(State.PUBLISHED)) {
            this.reviews.add(review);
        } else if (this.state.equals(State.PRIVATE) && this.students.contains(student)) {
            this.reviews.add(review);
        } else {
            throw new UnsupportedOperationException("드래프트 상태에서는 리뷰를 작성할 수 없습니다.");
        }
    }

    public State getState() {
        return state;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<String> getReviews() {
        return reviews;
    }

    public enum State {
        PRIVATE,
        PUBLISHED,
        DRAFT;
    }
}
