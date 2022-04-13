package com.study.designpatterns.seungchan_moon._4_builder.after;

import com.study.designpatterns.seungchan_moon._4_builder.before.TourPlan;

import java.time.LocalDate;

public class TourDirector {
    private TourPlanBuilder tourPlanBuilder;

    public TourDirector(TourPlanBuilder tourPlanBuilder) {
        this.tourPlanBuilder = tourPlanBuilder;
    }

    public TourPlan longBeachTrip(){
        return tourPlanBuilder.title("롱비치")
                .startDate(LocalDate.of(2021, 7, 15))
                .getPlan();
    }

    public TourPlan japanTrip(){
        return tourPlanBuilder.title("일본 여행")
                .nightsAndDays(2, 3)
                .whereToStay("호텔")
                .addPlan(0, "체크인하고 짐 풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();
    }
}
