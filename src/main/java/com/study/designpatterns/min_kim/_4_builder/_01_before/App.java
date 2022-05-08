package com.study.designpatterns.min_kim._4_builder._01_before;

import java.time.LocalDate;

public class App {

    public static void main(String[] args) {
        // 롱비치 여행 구성
        TourPlan longBeachTrip = new TourPlan();
        longBeachTrip.setTitle("오레곤 롱비치 여행");
        longBeachTrip.setStartDate(LocalDate.of(2022, 4, 19));

        TourPlan longBeachTrip2 = new TourPlan("오레곤 롱비치 여행", LocalDate.of(2022, 4, 19));

        // 칸쿤 여행 구성
        TourPlan cancunTrip = new TourPlan();
        cancunTrip.setTitle("칸쿤 여행");
        cancunTrip.setStartDate(LocalDate.of(2022, 4, 19));
        cancunTrip.setNights(3);
        cancunTrip.setDays(4);
        cancunTrip.setWhereToStay("칸쿤 호텔");
        cancunTrip.addPlan(0, "체크인");
        cancunTrip.addPlan(0, "저녁 식사");
        cancunTrip.addPlan(1, "해변가 산책");
        cancunTrip.addPlan(2, "체크아웃");

        TourPlan cancunTrip2 = new TourPlan("칸쿤 여행", 3, 2, LocalDate.of(2022, 4, 19), "리조트", null);
    }
}
