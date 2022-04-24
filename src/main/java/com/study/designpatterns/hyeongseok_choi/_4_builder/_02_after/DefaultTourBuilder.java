package com.study.designpatterns.hyeongseok_choi._4_builder._02_after;

import com.study.designpatterns.hyeongseok_choi._4_builder._01_before.DetailPlan;
import com.study.designpatterns.hyeongseok_choi._4_builder._01_before.TourPlan;

import java.time.LocalDate;
import java.util.List;

public class DefaultTourBuilder  implements TourPlanBuilder {
    private String title;
    private int nights;
    private int days;
    private LocalDate startDates;
    private String wheteToStay;
    private List<DetailPlan> plans;


    @Override
    public TourPlanBuilder title(String title) {
        return null;
    }

    @Override
    public TourPlanBuilder nightsAndDays(int nights, int days) {
        return null;
    }

    @Override
    public TourPlanBuilder startDates(LocalDate localDate) {
        return null;
    }

    @Override
    public TourPlanBuilder wheteToStay(String whereToStay) {
        return null;
    }

    @Override
    public TourPlanBuilder addPlan(int day, String plans) {
        return null;
    }

    @Override
    public TourPlan getPlan() {
        return new TourPlan(title, nights, days, startDates, wheteToStay, plans);
    }
}
