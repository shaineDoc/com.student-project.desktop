package com.course.desktop;

import com.course.desktop.mail.MailSender;
import com.course.desktop.domain.*;
import com.course.desktop.validator.ChildrenValidator;
import com.course.desktop.validator.CityRegisterValidator;
import com.course.desktop.validator.StudentValidator;
import com.course.desktop.validator.WeddingValidator;

public class StudentOrderValidator {
    private CityRegisterValidator cityRegisterVal;
    private WeddingValidator weddingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator() {
        cityRegisterVal = new CityRegisterValidator();
        weddingVal = new WeddingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }

    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll() {
        StudentOrder[] soArray = readStudentOrders();

        for(int c = 0; c < soArray.length; c++) {
            System.out.println();
            checkOneOrder(soArray[c]);
        }

//        for(StudentOrder so : soArray) {
//            System.out.println();
//            checkOneOrder(so);
//        }
    }

    public StudentOrder[] readStudentOrders() {
        StudentOrder[] soArray = new StudentOrder[1];

        for (int c = 0; c < soArray.length; c++) {
            soArray[c] = SaveStudentOrder.buildStudentOrder(c);
        }

        return soArray;
    }

    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);
//        AnswerWedding wedAnswer = checkWedding(so);
//        AnswerChildren childAnswer = checkChildren(so);
//        AnswerStudent studentAnswer = checkStudent(so);
//
//        sendMail(so);
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}