package com.course.desktop.dao;

import com.course.desktop.domain.Street;
import com.course.desktop.exception.DaoException;

import java.util.List;

public interface DictionaryDao {
    List<Street> findStreets(String pattern) throws DaoException;
}
