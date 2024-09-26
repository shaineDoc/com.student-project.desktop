package com.course.desktop.dao;

import com.course.desktop.domain.RegisterOffice;
import com.course.desktop.domain.Street;
import com.course.desktop.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern) throws DaoException;
    List<PassportOffice> findPassportOffice(String areaId) throws DaoException;
    List<RegisterOffice> findRegisterOffice(String areaId) throws DaoException;
}
