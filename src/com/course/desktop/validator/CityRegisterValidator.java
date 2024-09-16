package com.course.desktop.validator;

import com.course.desktop.domain.AnswerCityRegister;
import com.course.desktop.domain.CityRegisterCheckerResponse;
import com.course.desktop.domain.StudentOrder;
import com.course.desktop.exception.CityRegisterException;
import com.course.desktop.validator.register.CityRegisterChecker;
import com.course.desktop.validator.register.FakeCityRegisterChecker;

public class CityRegisterValidator {

    public String hostName;
    public int port;
    private String login;
    String password;

    private CityRegisterChecker personChecker;

    public CityRegisterValidator() {
        personChecker = new FakeCityRegisterChecker();
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so) {
        try {
            CityRegisterCheckerResponse hans = personChecker.checkPerson(so.getHusband());
            CityRegisterCheckerResponse wans = personChecker.checkPerson(so.getWife());
            CityRegisterCheckerResponse cans = personChecker.checkPerson(so.getChild());
        } catch (CityRegisterException ex) {
            ex.printStackTrace();
        }

        AnswerCityRegister ans = new AnswerCityRegister();
        return ans;
    }
}
