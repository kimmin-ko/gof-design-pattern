package com.study.designpatterns.yunjin_choi._4_builder;

import lombok.ToString;

/**
 * <pre>
 * com.study.designpatterns.yunjin_choi._4_builder
 *      Person
 * </pre>
 *
 * @author YunJin Choi(zzdd1558@gmail.com)
 * @since 2022-04-10 오후 9:48
 */

public class Person implements PersonBuilder {

    private String name;
    private Address address;
    private String email;
    private String phoneNumber;
    private int year;
    private int month;
    private int days;

    public Person() {}

    private Person(String name, Address address, String email, String phoneNumber, int year, int month, int days) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.year = year;
        this.month = month;
        this.days = days;
    }

    @Override
    public PersonBuilder name(String name) {
        this.name = name;
        return this;
    }

    @Override
    public PersonBuilder address(Address address) {
        this.address = address;
        return this;
    }

    @Override
    public PersonBuilder email(String email) {
        this.email = email;
        return this;
    }

    @Override
    public PersonBuilder phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    @Override
    public PersonBuilder birthday(int year, int month, int days) {
        this.year = year;
        this.month = month;
        this.days = days;
        return this;
    }

    @Override
    public Person build() {
        return new Person(this.name, this.address, this.email, this.phoneNumber,this.year, this.month, this.days);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", days=" + days +
                '}';
    }
}

class Address {
    private String zipCode;
    private String address1;
    private String address2;

    private Address(String zipCode, String address1, String address2) {
        this.zipCode = zipCode;
        this.address1 = address1;
        this.address2 = address2;
    }

    private void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    private void setAddress1(String address1) {
        this.address1 = address1;
    }

    private void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                '}';
    }

    public static class Builder {
        private String zipCode;
        private String address1;
        private String address2;

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder address1(String address1) {
            this.address1 = address1;
            return this;
        }

        public Builder address2(String address2) {
            this.address2 = address2;
            return this;
        }

        public Address build() {
            // 여기에 validation 체크 가능 
            return new Address(zipCode, address1, address2);
        }
    }
}
