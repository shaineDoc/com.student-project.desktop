package com.course.desktop;

import com.course.desktop.domain.Address;
import com.course.desktop.domain.Adult;
import com.course.desktop.domain.StudentOrder;

public class SaveStudentOrder {
    public static void main(String[] args) {
        buildStudentOrder(10);
//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);

    }
    // Сохраняем заявку и присваиваем порядковый номер
    static long saveStudentOrder (StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("SaveStudentOrder:  ");
        return answer;
    }
    static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        StudentOrder so1 = so;
        printStudentOrder(so1);

        return so;
    }
    static void printStudentOrder(StudentOrder studentOrder) {
        System.out.println(studentOrder);
    }
}
