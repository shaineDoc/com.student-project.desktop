package com.course.desktop.validator;

import com.course.desktop.domain.wedding.AnswerWedding;
import com.course.desktop.domain.StudentOrder;

public class WeddingValidator {
    public AnswerWedding checkWedding(StudentOrder so) {
        System.out.println("Wedding running");
        return new AnswerWedding();
    }

}
