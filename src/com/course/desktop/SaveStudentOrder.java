package com.course.desktop;

import com.course.desktop.domain.Adult;
import com.course.desktop.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {

        StudentOrder so = new StudentOrder(); // создаём объект и присваиваем имена


       long ans = saveStudentOrder(so);
        System.out.println(ans);

    }
    // Сохраняем заявку и присваиваем порядковый номер
    static long saveStudentOrder (StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("SaveStudentOrder:  ");
        return answer;
    }
    static StudentOrder buildStudentOrder() {
        StudentOrder so = new StudentOrder();
        Adult husband = new Adult();
        husband.setGivenName("Вячеслав");
        so.setHusband(husband);

        return so;
    }
}
