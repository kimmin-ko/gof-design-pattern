package com.study.designpatterns.min_kim._4_builder._02_after;

import com.study.designpatterns.min_kim._4_builder._01_before.TourPlan;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        TourPlanBuilder builder = new DefaultTourPlanBuilder();

        TourPlan cancunTrip = builder
                .title("칸쿤 여행")
                .nightsAndDays(2, 3)
                .startDate(LocalDate.of(2022, 4, 19))
                .whereToStay("리조트")
                .addPlan(0, "체크인")
                .addPlan(1, "저녁식사")
                .addPlan(2, "체크아웃")
                .getPlan();

        System.out.println("cancunTrip = " + cancunTrip);

        TourPlan longBeachTrip = builder
                .title("롱비치")
                .startDate(LocalDate.of(2022, 4, 19))
                .getPlan();

        System.out.println("longBeachTrip = " + longBeachTrip);

        TourDirector tourDirector = new TourDirector(new DefaultTourPlanBuilder());
        TourPlan cancunTrip1 = tourDirector.cancunTrip();
        TourPlan longBeachTrip1 = tourDirector.longBeachTrip();
    }
}