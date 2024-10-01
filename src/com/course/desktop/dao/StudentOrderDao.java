package com.course.desktop.dao;

import com.course.desktop.domain.StudentOrder;
import com.course.desktop.exception.DaoException;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoException;
}
