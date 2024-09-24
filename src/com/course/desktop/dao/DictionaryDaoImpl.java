package com.course.desktop.dao;

import com.course.desktop.domain.Street;
import com.course.desktop.exception.DaoException;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao {
    private static final String GET_STREET = "SELECT street_code, street_name FROM jc_street WHERE UPPER (street_name )LIKE upper" +
            " (?)";
    private Connection getConnection() throws SQLException {
        //    Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/",
                "postgres", "admin");
        return connection;
    }

    public List<Street> findStreets(String pattern) throws DaoException {
        List<Street> result = new LinkedList<>();

        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement(GET_STREET)) {

            stmt.setString(1, "%" +  pattern + "%");
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

}
