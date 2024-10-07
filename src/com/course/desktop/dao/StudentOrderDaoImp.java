package com.course.desktop.dao;

import com.course.desktop.config.Config;
import com.course.desktop.domain.*;
import com.course.desktop.exception.DaoException;
import com.course.desktop.offices.PassportOffice;
import com.course.desktop.offices.RegisterOffice;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class StudentOrderDaoImp implements StudentOrderDao {
    PassportOffice ps = new PassportOffice();

    public static final String INSERT_ORDER = "INSERT INTO jc_student_order(" +
            "student_order_status, student_order_date, h_sur_name, h_given_name, h_patronymic," + // 5
            " h_date_of_birth, h_passport_seria, h_passport_number," + // 3
            " h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building," + // 5
            " h_extension, h_apartment,h_university_id, h_student_number,  w_sur_name, w_given_name," + // 6
            " w_patronymic, w_date_of_birth, w_passport_seria, w_passport_number, w_passport_date," + // 5
            " w_passport_office_id, w_post_index,w_street_code, w_building, w_extension, w_apartment," + // 6
            " w_university_id, w_student_number, certificate_id, register_office_id, marriage_date)" + // 5
            "VALUES (" +
            "?, ?, ?, ?, ?," +
            " ?, ?, ?, " +
            "?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?," +
            " ?, ?, ?, ?, ?, ? ," +
            " ?, ?, ?, ?, ?);";


    private static final String INSERT_CHILD =
            "INSERT INTO jc_student_child(" +
                    " student_order_id, c_sur_name, c_given_name, " +
                    " c_patronymic, c_date_of_birth, c_certificate_number, c_certificate_date, " +
                    " c_register_office_id, c_post_index, c_street_code, c_building, " +
                    " c_extension, c_apartment)" +
                    " VALUES (?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?, ?, ?, " +
                    " ?, ?)";

    private static final String SELECT_ORDERS =
            "SELECT * FROM jc_student_order_status = 0 ORDER BY student_order_date";

    // TODO refactoring - make one method
    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return connection;
    }

    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoException {
        Long result = -1L;
        try (Connection connection = getConnection();
             //TODO: прочесть подробнее про PreparedStatement
             PreparedStatement stmt = connection.prepareStatement(INSERT_ORDER, new String[]{"student_order_id"})) {

            //TODO: прочесть подробнее про connection.setAutoCommit(false);
            connection.setAutoCommit(false);
            try {
                // основные параметры
                stmt.setInt(1, StudentOrderStatus.START.ordinal());
                stmt.setTimestamp(2, java.sql.Timestamp.valueOf(LocalDateTime.now()));

                // муж
                setParamForAdult(stmt, 3, so.getHusband());
                setParamForAdult(stmt, 18, so.getWife());
                // брак
                stmt.setString(33, so.getMarriageCertificateId());
                stmt.setLong(34, so.getMarriageOffice().getOfficeId());
                stmt.setDate(35, java.sql.Date.valueOf(so.getMarriageDate()));

                stmt.executeUpdate();

                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    result = generatedKeys.getLong(1);
                }
                generatedKeys.close();
                saveChildren(connection, so, result);
                connection.commit();
            } catch (SQLException ex) {
                connection.rollback();
                throw ex;
            }

        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }


    @Override
    public List<StudentOrder> getStudentOrders() throws DaoException {
        List<StudentOrder> result = new LinkedList<>();
        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(SELECT_ORDERS)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                StudentOrder so = new StudentOrder();
                fillStudentOrder(rs, so);
                fillMarriage(rs, so);
                result.add(so);
            }
            rs.close();
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    private void fillStudentOrder(ResultSet rs, StudentOrder so) throws SQLException {
        so.setStudentOrderId(rs.getLong("student_order_id"));
        so.setStudentOrderDate(rs.getTimestamp("student_order_date").toLocalDateTime());
        so.setStudentOrderStatus(StudentOrderStatus.fromValue(rs.getInt("student_order_status")));
    }

    private void fillMarriage(ResultSet rs, StudentOrder so) throws SQLException {
        so.setMarriageCertificateId(rs.getString("certificate_id"));
        so.setMarriageDate(rs.getDate("marriage_date").toLocalDate());

        Long roId = rs.getLong("marriage_office_id");
        RegisterOffice ro = new RegisterOffice(roId,"","");
        so.setMarriageOffice(ro);
    }

    private void saveChildren(Connection con, StudentOrder so, long soId) throws SQLException {
        try (PreparedStatement stmt = con.prepareStatement(INSERT_CHILD)) {
            for (Child child : so.getChildren()) {
                stmt.setLong(1, soId);
                setParamsForChild(stmt, child);
                stmt.addBatch();

            }
            stmt.executeBatch();
        }
    }

    private static void setParamForAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
        setParamsForPerson(stmt, start, adult);
        stmt.setString(start + 4, adult.getPassportSeria());
        stmt.setString(start + 5, adult.getPassportNumber());
        stmt.setDate(start + 6, Date.valueOf(adult.getIssueDate()));
        stmt.setLong(start + 7, adult.getIssueDepartment().getOfficeId());
        setParamsForAddress(stmt, start + 8, adult);
        stmt.setLong(start + 13, adult.getUniversity().getUniversityId());
        stmt.setString(start + 14, adult.getStudentId());
    }

    private void setParamsForChild(PreparedStatement stmt, Child child) throws SQLException {
        setParamsForPerson(stmt, 2, child);
        stmt.setString(6, child.getCertificateNumber());
        stmt.setDate(7, java.sql.Date.valueOf(child.getDateOfBirth()));
        stmt.setLong(8, child.getIssueDepartment().getOfficeId());
        setParamsForAddress(stmt, 9, child);
    }


    private static void setParamsForPerson(PreparedStatement stmt, int start, Person person) throws SQLException {
        stmt.setString(start, person.getSurName());
        stmt.setString(start + 1, person.getGivenName());
        stmt.setString(start + 2, person.getPatronymic());
        stmt.setDate(start + 3, Date.valueOf(person.getDateOfBirth()));
    }

    private static void setParamsForAddress(PreparedStatement stmt, int start, Person person) throws SQLException {
        Address adult_address = person.getAddress();
        stmt.setString(start, adult_address.getPostCode());
        stmt.setLong(start + 1, adult_address.getStreet().getStreetCode());
        stmt.setString(start + 2, adult_address.getBuilding());
        stmt.setString(start + 3, adult_address.getExtension());
        stmt.setString(start + 4, adult_address.getApartment());
    }

}
