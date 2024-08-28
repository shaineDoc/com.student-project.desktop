package com.course.desktop.domain;

import java.time.LocalDate;

public abstract class Person {
    protected String surName;
    protected String givenName;
    private String patronymic;
    private LocalDate birthDay;
    private Address address;

    public Person(String surName, String givenName, String patronymic, LocalDate birthDay) {
        this.surName = surName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.birthDay = birthDay;

    }

    public String getPersonString() {
        return surName + " " + givenName;
    }


    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
