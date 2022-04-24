package com.study.designpatterns.hyeongseok_choi._4_builder._01_before;

import java.time.LocalDate;

public class App {

    TourPlan shortTrip = new TourPlan();
    shortTrip.setTitle("오레곤 롱비치 여행");
    shortTrip.setStartDate(LocalDate.of(2021,7,15));


//    장황하고, 특정 속성은 빼놓기가 쉬워짐
    TourPlan tourPlan = new TourPlan();
    tourPlan.setTitle("칸쿤 여행");
    tourPlan.setStartDate(LocalDate.of(2021,7,15));
    tourPlan.setNights(2);
    tourPlan.setDays(3);
    tourPlan.addPlan(0, "체크인 이후 잠들기")
    tourPlan.addPlan(1, "...")
    tourPlan.addPlan(1, "...")
    tourPlan.addPlan(2, "...")
    tourPlan.addPlan(2, "...")
    tourPlan.addPlan(3, "...")
}
