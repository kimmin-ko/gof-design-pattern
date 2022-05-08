package com.study.designpatterns.min_kim._2_factory_method._01_before;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/* 문제점
    - 배에 대한 요구 사항이 있을 때마다 클래스를 변경해야 한다.
    - 확장에는 열려있지만 변경에는 닫혀있지 않다.
   해결책
    - Ship을 인터페이스로 변경하고 각각의 배는 Ship을 구현한다. (다형성)
 */
@Getter
@Setter
@ToString
public class Ship {
    private String name;
    private String color;
    private String logo;
}