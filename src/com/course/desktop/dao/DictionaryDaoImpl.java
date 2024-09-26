package com.course.desktop.dao;

import com.course.desktop.config.Config;
import com.course.desktop.domain.RegisterOffice;
import com.course.desktop.domain.Street;
import com.course.desktop.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    private static final String GET_STREET = "SELECT street_code, street_name FROM jc_street WHERE upper (street_name)LIKE UPPER" +
            " (?)";
    public static final String GET_PASSPORT = "SELECT * From jc_passport_office WHERE p_office_area_id = ?";
    public static final String GET_REGISTER = "SELECT * From jc_register_office WHERE r_office_area_id = ?";

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN),
                Config.getProperty(Config.DB_PASSWORD));
        return connection;
    }

    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_STREET)) {

            stmt.setString(1, "%" + pattern + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                result.add(str);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }

    @Override
    public List<PassportOffice> findPassportOffice(String areaId) throws DaoException {
        List<PassportOffice> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_PASSPORT)) {

            stmt.setString(1,areaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PassportOffice ps = new PassportOffice(rs.getLong("p_office_id"),
                        rs.getString("p_office_area_id"), rs.getString("p_office_name"));
                result.add(ps);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }


    @Override
    public List<RegisterOffice> findRegisterOffice(String areaId) throws DaoException {
        List<RegisterOffice> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_REGISTER)) {

            stmt.setString(1,areaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RegisterOffice ro = new RegisterOffice(rs.getLong("r_office_id"),
                        rs.getString("r_office_area_id"), rs.getString("r_office_name"));
                result.add(ro);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex);
        }
        return result;
    }
}

