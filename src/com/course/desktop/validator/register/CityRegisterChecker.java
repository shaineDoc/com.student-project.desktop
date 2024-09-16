package com.course.desktop.validator.register;

import com.course.desktop.domain.CityRegisterCheckerResponse;
import com.course.desktop.domain.Person;
import com.course.desktop.exception.CityRegisterException;

public interface CityRegisterChecker {
    CityRegisterCheckerResponse checkPerson (Person person) throws CityRegisterException;
}
