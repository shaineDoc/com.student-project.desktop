package com.course.desktop.validator.register;

import com.course.desktop.domain.register.CityRegisterResponse;
import com.course.desktop.domain.Person;
import com.course.desktop.exception.CityRegisterException;
import com.course.desktop.exception.TransportException;

public interface CityRegisterChecker {
    CityRegisterResponse checkPerson (Person person)
            throws CityRegisterException, TransportException;
}
