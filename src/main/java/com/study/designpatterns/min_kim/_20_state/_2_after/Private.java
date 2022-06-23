package com.study.designpatterns.min_kim._20_state._2_after;

public class Private implements State {

    private final OnlineCourse onlineCourse;

    public Private(OnlineCourse onlineCourse) {
        this.onlineCourse = onlineCourse;
    }

    @Override
    public void addStudent(Student student) {
        if (student.isAvailable(this.onlineCourse)) {
            this.onlineCourse.getStudents().add(student);
            return;
        }

        throw new UnsupportedOperationException("프라이빗 코스를 수강할 수 없습니다.");
    }

    @Override
    public void addReview(String review, Student student) {
        if (this.onlineCourse.contains(student)) {
            this.onlineCourse.getReviews().add(review);
            return;
        }

        throw new UnsupportedOperationException("프라이빗 코스를 수강하는 학생만 리뷰를 남길 수 있습니다.");
    }
}
