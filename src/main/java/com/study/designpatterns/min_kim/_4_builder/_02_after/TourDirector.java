package com.study.designpatterns.min_kim._4_builder._02_after;

import com.study.designpatterns.min_kim._4_builder._01_before.TourPlan;

import java.time.LocalDate;

public class TourDirector {

    private final TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTrip() {
        return tourPlanBuilder
                .title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2022, 4, 19))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .addPlan(2, "체크아웃")
                .getPlan();
    }

    public TourPlan longBeachTrip() {
        return tourPlanBuilder
                .title("롱비치")
                .startDate(LocalDate.of(2022, 4, 19))
                .getPlan();
    }
}
