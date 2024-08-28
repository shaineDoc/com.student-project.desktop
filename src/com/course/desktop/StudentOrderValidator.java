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
        for (StudentOrder so : soArray) {
            System.out.println();
            checkStudent(so);
        }
//        for (int i = 0; i < soArray.length; i++) {
//            System.out.println();
//            checkOneOrder(soArray[i]);
//        }
    }


    // читаем поступившие заявки
    public StudentOrder[] readStudentOrders() {
        StudentOrder[] soArray = new StudentOrder[3];

        for (int c = 0; c < soArray.length; c++) {
            soArray[c] = SaveStudentOrder.buildStudentOrder(c);

        }
        return soArray;

    }

    // Проверка поступивших заявок
    public void checkOneOrder(StudentOrder so) {
        AnswerCityRegister cityAnswer = checkCityRegister(so);

        AnswerWedding wedAnswer = checkWedding(so);
        AnswerChildren childAnswer = checkChildren(so);
        AnswerStudent studAnswer = checkStudent(so);

        sendMail(so);

    }

    // Проверяем адрес регистрации
    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        return cityRegisterVal.checkCityRegister(so);

    }

    //  Проверка брака
    public AnswerWedding checkWedding(StudentOrder so) {
        return weddingVal.checkWedding(so);
    }

    // проверка на наличие детей
    public AnswerChildren checkChildren(StudentOrder so) {
        return childrenVal.checkChildren(so);
    }

    //  Проверка на причастность к студентчеству
    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    // отправка какого-то ответа по заявке
    public void sendMail(StudentOrder so) {
        mailSender.sendMail(so);
    }
}
