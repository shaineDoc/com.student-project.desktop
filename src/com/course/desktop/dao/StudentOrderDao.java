package com.course.desktop.dao;

import com.course.desktop.domain.StudentOrder;
import com.course.desktop.exception.DaoException;

import java.util.List;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoException;
    List <StudentOrder> getStudentOrders() throws DaoException;
}
