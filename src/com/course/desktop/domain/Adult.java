package com.course.desktop.domain;

import java.time.LocalDate;

public class Adult extends Person {
    private String pasportSeria;
    private String passportNumber;

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    private LocalDate issueDate;
    private String issueDepartment;
    private String university;
    private String studentId;


    public Adult(String surName, String givenName, String patronymic, LocalDate birthDay) {
        super(surName, givenName, patronymic, birthDay);
    }


    public String getPersonString() {
        return surName + " " + givenName + " " + passportNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getIssueDepartment() {
        return issueDepartment;
    }

    public void setIssueDepartment(String issueDepartment) {
        this.issueDepartment = issueDepartment;
    }


    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getPasportSeria() {
        return pasportSeria;
    }

    public void setPasportSeria(String pasportSeria) {
        this.pasportSeria = pasportSeria;
    }

}
