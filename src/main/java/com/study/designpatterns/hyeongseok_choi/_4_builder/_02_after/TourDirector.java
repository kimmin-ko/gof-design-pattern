package com.study.designpatterns.hyeongseok_choi._4_builder._02_after;

import com.study.designpatterns.hyeongseok_choi._4_builder._01_before.TourPlan;

import java.time.LocalDate;

// 반복적으로 동일하게 빌더를 사용한다면 디렉터를 이용할 수 있
public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan cancunTrip() {
        return tourPlanBuilder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDates(LocalDate.of(2020, 12, 9))
                .wheteToStay("리조트")
                .addPlan(1, "체크인하고 짐 풀기")
                .addPlan(2, "...")
                .getPlan();
    }

    public TourPlan longBeachTrip() {
        return tourPlanBuilder.title("롱비치")
                .startDates(LocalDate.of(2021, 7, 15))
                .getPlan();
    }
}

