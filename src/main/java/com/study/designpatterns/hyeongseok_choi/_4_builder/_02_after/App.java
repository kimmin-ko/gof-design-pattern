package com.study.designpatterns.hyeongseok_choi._4_builder._02_after;

import com.study.designpatterns.hyeongseok_choi._4_builder._01_before.TourPlan;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        TourPlanBuilder builder = new DefaultTourBuilder();
        builder.title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDates(LocalDate.of(2020, 12, 9))
                .wheteToStay("리조트")
                .addPlan(1, "체크인하고 짐 풀기")
                .addPlan(2, "...")
                .getPlan();

        TourPlan longBeachTrip = builder.title("롱비치")
                .startDates(LocalDate.of(2021, 7, 15))
                .getPlan();

        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan  tourPlan = director.cancunTrip();
        TourPlan tourPlan1 = director.longBeachTrip();
    }
}
