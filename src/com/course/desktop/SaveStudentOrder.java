package com.course.desktop;

import com.course.desktop.domain.Address;
import com.course.desktop.domain.Adult;
import com.course.desktop.domain.Child;
import com.course.desktop.domain.StudentOrder;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) {
    StudentOrder s = buildStudentOrder(10);
//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);

    }

    // Сохраняем заявку и присваиваем порядковый номер
    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("SaveStudentOrder");
        return answer;

    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016,7,4));
        so.setMarriageOffice("Отдел ЗАГС");

        Address address = new Address("195000", "Заневский пр.", "12", "", "142");
        // МУЖ
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPasportSeria("" + (1000 + id));
        husband.setPassportNumber(" " + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        husband.setIssueDepartment("Отдел милиции № " + id);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        // ЖЕНА
        Adult wife = new Adult("Петрова","Вероника","Алексеевна", LocalDate.of(1998, 3, 12));
        wife.setPasportSeria("" + (2000 + id));
        wife.setPassportNumber(" " + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        wife.setIssueDepartment("Отдел милиции № " + id);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        // РЕБЕНОК
        Child child = new Child("Петрова","Ирина","Викторовна",LocalDate.of(2018,6,29));
        child.setCertificateNumber("" + (300000 + id));
        child.setIssueDate(LocalDate.of(2018,7,19));
        child.setIssueDepartment("Отдел милиции № " + id);
        child.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.setChild(child);

        return so;
    }

    static void printStudentOrder(StudentOrder studentOrder) {
        System.out.println(studentOrder);
    }
}
