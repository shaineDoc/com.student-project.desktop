package com.course.desktop.validator;

import com.course.desktop.domain.CityRegisterCheckerResponse;
import com.course.desktop.domain.Person;

public interface CityRegisterChecker {
    CityRegisterCheckerResponse checkPerson (Person person);
}
