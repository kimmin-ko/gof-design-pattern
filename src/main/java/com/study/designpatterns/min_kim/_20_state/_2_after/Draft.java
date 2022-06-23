package com.study.designpatterns.min_kim._20_state._2_after;

public class Draft implements State {

    private final OnlineCourse onlineCourse;

    public Draft(OnlineCourse onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    @Override
    public void addStudent(Student student) {
        this.onlineCourse.getStudents().add(student);

        if (this.onlineCourse.getStudents().size() > 1) {
            this.onlineCourse.changeState(new Private(this.onlineCourse));
        }
    }

    @Override
    public void addReview(String review, Student student) {
        throw new UnsupportedOperationException("드래프트 상태에서는 리뷰를 추가할 수 없습니다.");
    }
}
