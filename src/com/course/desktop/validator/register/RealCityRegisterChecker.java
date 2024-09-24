package com.course.desktop.validator.register;

import com.course.desktop.domain.register.CityRegisterResponse;
import com.course.desktop.domain.Person;
import com.course.desktop.exception.CityRegisterException;
import com.course.desktop.exception.TransportException;

import javax.xml.transform.TransformerException;

public class RealCityRegisterChecker implements CityRegisterChecker {
    @Override
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException, TransportException {
    return null;
    }
}
