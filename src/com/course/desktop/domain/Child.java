package com.course.desktop.domain;

import com.course.desktop.offices.RegisterOffice;

import java.time.LocalDate;

public class Child extends Person {
    private String certificateNumber;
    private RegisterOffice issueDepartment;
    private LocalDate issueDate;

    public Child(String surName, String givenName, String patronymic, LocalDate birthDay) {
        super(surName, givenName, patronymic, birthDay);
    }


    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public RegisterOffice getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(RegisterOffice issueDepartment) {
        this.issueDepartment = issueDepartment;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }



}
