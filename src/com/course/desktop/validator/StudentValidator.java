package com.course.desktop.validator;

import com.course.desktop.domain.student.AnswerStudent;
import com.course.desktop.domain.StudentOrder;

public class StudentValidator {
   public  AnswerStudent checkStudent(StudentOrder so) {
        System.out.println("Student checking");
        return new AnswerStudent();
    }
}
