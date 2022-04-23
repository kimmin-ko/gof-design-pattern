package com.study.designpatterns.seungchan_moon._4_builder.after;

import com.study.designpatterns.seungchan_moon._4_builder.before.TourPlan;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        TourPlanBuilder builder = new DefaultTourBuilder();
//        builder.title("일본 여행");
//        builder.nightsAndDays(2, 3);
        TourPlan plan = builder.title("일본 여행")
                .nightsAndDays(2, 3)
                .whereToStay("호텔")
                .addPlan(0, "체크인하고 짐 풀기")
                .addPlan(0, "저녁 식사")
                .getPlan();

        TourPlan longBeachTrip = builder.title("롱비치")
                .startDate(LocalDate.of(2021, 7, 15))
                .getPlan();

        TourDirector director = new TourDirector(new DefaultTourBuilder());
        TourPlan plan1 = director.japanTrip();
        TourPlan plan2 = director.longBeachTrip();
    }
}
