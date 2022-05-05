package com.study.designpatterns.min_kim._7_bridge._3_java_and_spring;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Entity
public class Exam {

    @Id
    private Long id;

}
