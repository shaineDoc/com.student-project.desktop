package com.course.desktop.validator;

import com.course.desktop.domain.children.AnswerChildren;
import com.course.desktop.domain.StudentOrder;

public class ChildrenValidator {
   public AnswerChildren checkChildren(StudentOrder so) {
        System.out.println("Children check is running");
        return new AnswerChildren();
    }
}
