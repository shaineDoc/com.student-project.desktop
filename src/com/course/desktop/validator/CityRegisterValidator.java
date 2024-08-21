package com.course.desktop.validator;

import com.course.desktop.domain.AnswerCityRegister;
import com.course.desktop.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName;
    public int port;
    private String login;
    String password;

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        System.out.println("CityRegister is running: " + hostName + " " + login + " " + password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success = false;
        return ans;
    }
}
