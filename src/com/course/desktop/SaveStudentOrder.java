package com.course.desktop;

import com.course.desktop.dao.StudentOrderDao;
import com.course.desktop.dao.StudentOrderDaoImp;
import com.course.desktop.offices.PassportOffice;
import com.course.desktop.domain.*;
import com.course.desktop.offices.RegisterOffice;

import java.time.LocalDate;
import java.util.List;

public class SaveStudentOrder {
    public static void main(String[] args) throws Exception {
//        List<Street> d = new DictionaryDaoImpl().findStreets("ст");
//        for(Street s : d) {
//            System.out.println(s.getStreetName());
//        }
//      List <PassportOffice> po =   new DictionaryDaoImpl().findPassportOffice("010020000000");
//        for(PassportOffice p : po) {
//            System.out.println(p.getOfficeName());
//        }
//        List <RegisterOffice> ro =   new DictionaryDaoImpl().findRegisterOffice("010010000000");
//        for( RegisterOffice r : ro) {
//            System.out.println(r.getOfficeName());
//        }
//        List <CountryArea> ca1 =   new DictionaryDaoImpl().findAreas("");
//        for( CountryArea countryArea : ca1) {
//            System.out.println(countryArea.getAreaId() + ":" + countryArea.getAreaName());
//        }
//        List <CountryArea> ca2 =   new DictionaryDaoImpl().findAreas("020000000000");
//        for( CountryArea countryArea : ca2) {
//            System.out.println(countryArea.getAreaId() + ":" + countryArea.getAreaName());
//        }
//        List <CountryArea> ca3 =   new DictionaryDaoImpl().findAreas("020010000000");
//        for( CountryArea countryArea : ca3) {
//            System.out.println(countryArea.getAreaId() + ":" + countryArea.getAreaName());
//        }
//        List <CountryArea> ca4 =   new DictionaryDaoImpl().findAreas("020010010000");
//        for( CountryArea countryArea : ca4) {
//            System.out.println(countryArea.getAreaId() + ":" + countryArea.getAreaName());
//        }
       // StudentOrder s = buildStudentOrder(10);
        StudentOrderDao dao = new StudentOrderDaoImp();
      //  Long id = dao.saveStudentOrder(s);
       // System.out.println(id);

        List<StudentOrder> soList = dao.getStudentOrders();
        for (StudentOrder so : soList) {
            System.out.println("student order id: " + so.getStudentOrderId());
        }
//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }

    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder");

        return answer;
    }

    public static StudentOrder buildStudentOrder(long id) {
        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);
        so.setMarriageCertificateId("" + (123456000 + id));
        so.setMarriageDate(LocalDate.of(2016, 7, 4));
        RegisterOffice regOffice = new RegisterOffice(1L, "", "");
        so.setMarriageOffice(regOffice);

        Street street = new Street(1L, "First street");

        Address address = new Address("195000", street, "12", "", "142");

        // Муж
        Adult husband = new Adult("Петров", "Виктор", "Сергеевич", LocalDate.of(1997, 8, 24));
        husband.setPassportSeria("" + (1000 + id));
        husband.setPassportNumber("" + (100000 + id));
        husband.setIssueDate(LocalDate.of(2017, 9, 15));
        PassportOffice ps = new PassportOffice(1L, "", "");
        husband.setIssueDepartment(ps);
        husband.setStudentId("" + (100000 + id));
        husband.setAddress(address);
        husband.setUniversity(new University(2L, ""));
        husband.setStudentId("RU 022014");
        // Жена
        Adult wife = new Adult("Петрова", "Вероника", "Алекссевна", LocalDate.of(1998, 3, 12));
        wife.setPassportSeria("" + (2000 + id));
        wife.setPassportNumber("" + (200000 + id));
        wife.setIssueDate(LocalDate.of(2018, 4, 5));
        PassportOffice ps2 = new PassportOffice(2L, "", "");
        wife.setIssueDepartment(ps2);
        wife.setStudentId("" + (200000 + id));
        wife.setAddress(address);
        wife.setUniversity(new University(1L, ""));
        wife.setStudentId("RU 012011");
        // Ребенок
        Child child1 = new Child("Петрова", "Ирина", "Викторовна", LocalDate.of(2018, 6, 29));
        child1.setCertificateNumber("" + (300000 + id));
        child1.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro1 = new RegisterOffice(2L, "", "");
        child1.setIssueDepartment(ro1);
        child1.setAddress(address);
        // Ребенок 2
        Child child2 = new Child("Петров", "Евгений", "Викторович", LocalDate.of(2018, 6, 29));
        child2.setCertificateNumber("" + (400000 + id));
        child2.setIssueDate(LocalDate.of(2018, 7, 19));
        RegisterOffice ro2 = new RegisterOffice(3L, "", "");
        child2.setIssueDepartment(ro2);
        child2.setAddress(address);

        so.setHusband(husband);
        so.setWife(wife);
        so.addChild(child1);
        so.addChild(child2);

        return so;
    }
}