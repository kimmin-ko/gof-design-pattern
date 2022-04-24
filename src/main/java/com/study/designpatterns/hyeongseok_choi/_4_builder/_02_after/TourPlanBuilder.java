package com.study.designpatterns.hyeongseok_choi._4_builder._02_after;

import com.study.designpatterns.hyeongseok_choi._4_builder._01_before.TourPlan;

import java.time.LocalDate;

public interface TourPlanBuilder {

    TourPlanBuilder title(String title);
    TourPlanBuilder nightsAndDays(int nights, int days);
    TourPlanBuilder startDates(LocalDate localDate);
    TourPlanBuilder wheteToStay(String whereToStay);
    TourPlanBuilder addPlan(int day, String plans);

    TourPlan getPlan();
}
