package com.course.desktop.validator.register;

import com.course.desktop.domain.Adult;
import com.course.desktop.domain.Child;
import com.course.desktop.domain.register.CityRegisterResponse;
import com.course.desktop.domain.Person;
import com.course.desktop.exception.CityRegisterException;
import com.course.desktop.exception.TransportException;

public class FakeCityRegisterChecker implements CityRegisterChecker {

    private static final String GOOD_1 = "1000";
    private static final String GOOD_2 = "2000";
    private static final String BAD_1 = "1001";
    private static final String BAD_2 = "2001";
    private static final String ERROR_1 = "1002";
    private static final String ERROR_2 = "2002";
    private static final String ERROR_T_1 = "1003";
    private static final String ERROR_T_2 = "2003";

    @Override
    public CityRegisterResponse checkPerson(Person person)
            throws CityRegisterException, TransportException {
        CityRegisterResponse response = new CityRegisterResponse();
        if (person instanceof Adult) {
            Adult t = (Adult)person;
            String ps = t.getPassportSeria();
            if (ps.equals(GOOD_1)||ps.equals(GOOD_2)) {

                response.setExisting(true);
                response.setTemporal(false);
            }
            if (ps.equals(BAD_1)||ps.equals(BAD_2)) {
                response.setExisting(false);
            }
            if (ps.equals(ERROR_1) || ps.equals(ERROR_2)) {
                CityRegisterException ex = new CityRegisterException("1","GRN ERROR " + ps);
                throw ex;
            }
            if (ps.equals(ERROR_T_1) || ps.equals(ERROR_T_2)) {
                TransportException ex = new TransportException("TRANSPORT ERROR " + ps);
                throw ex;
            }

        }
        if (person instanceof Child) {
            response.setExisting(true);
            response.setTemporal(true);
        }

        System.out.println(response);

        return response;

    }
}
