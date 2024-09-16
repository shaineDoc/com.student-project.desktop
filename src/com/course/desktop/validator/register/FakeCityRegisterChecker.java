package com.course.desktop.validator.register;

import com.course.desktop.domain.Adult;
import com.course.desktop.domain.CityRegisterCheckerResponse;
import com.course.desktop.domain.Person;
import com.course.desktop.exception.CityRegisterException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    @Override
    public CityRegisterCheckerResponse checkPerson(Person person)
            throws CityRegisterException {
        if (person instanceof Adult) {
            Adult t = (Adult)person;
            String ps = t.getPasportSeria();
            if (ps.equals("1000")||ps.equals("2000")) {
                CityRegisterCheckerResponse response = new CityRegisterCheckerResponse();
                response.setExisting(true);
                response.setTemporal(false);
            }
        }
        return null;

    }
}
