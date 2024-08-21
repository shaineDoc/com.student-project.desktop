package com.course.desktop;

import com.course.desktop.mail.MailSender;
import com.course.desktop.domain.*;
import com.course.desktop.validator.ChildrenValidator;
import com.course.desktop.validator.CityRegisterValidator;
import com.course.desktop.validator.StudentValidator;
import com.course.desktop.validator.WeddingValidator;

public class StudentOrderValidator {
    public static void main(String[] args) {
        checkAll();
    }

    static void checkAll() {

        while (true) {
            StudentOrder so = readStudentOrder();
            if (so == null) {
                break;
            }

            AnswerCityRegister cityAnswer = checkCityRegister(so);
            if (!cityAnswer.success) {
                break;

                //continue;
            }
            AnswerWedding wedAnswer = checkWedding(so);
            AnswerChildren childAnswer = checkChildren(so);
            AnswerStudent studAnswer = checkStudent(so);

            sendMail(so);
        }
    }


    // читаем поступившие заявки
    static StudentOrder readStudentOrder() {
        StudentOrder so = new StudentOrder();
        return so;
    }

    // Проверяем адрес регистрации
    static AnswerCityRegister checkCityRegister(StudentOrder so) {
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "Host1";
        AnswerCityRegister answerCityRegister1 = crv1.checkCityRegister(so);
        return answerCityRegister1;

    }

    //  Проверка брака
    static AnswerWedding checkWedding(StudentOrder so) {
        WeddingValidator wd = new WeddingValidator();
        return wd.checkWedding(so);
    }

    // проверка на наличие детей
    static AnswerChildren checkChildren(StudentOrder so) {
        ChildrenValidator cv = new ChildrenValidator();
        return cv.checkChildren(so);
    }

    //  Проверка на причастность к студентчеству
    static AnswerStudent checkStudent(StudentOrder so) {
        StudentValidator sv = new StudentValidator();
        return sv.checkStudent(so);
    }

    // отправка какого-то ответа по заявке
    static void sendMail(StudentOrder so) {
        new MailSender().sendMail(so);
    }
}
