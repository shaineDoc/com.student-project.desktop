package com.course.desktop.dao;

import com.course.desktop.domain.Street;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DirectoryDao {
    private Connection getConnection() throws SQLException {
        //    Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/",
                "postgres", "admin");
        return connection;
    }

    public List<Street> findStreets(String pattern) throws Exception {
        List<Street> result = new LinkedList<>();
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        String sql = "SELECT street_code, street_name FROM jc_street WHERE UPPER (street_name )LIKE upper" +
                " ('%" + pattern + "%')";
        ResultSet rs = stmt.executeQuery("SELECT * FROM jc_street");
        while (rs.next()) {
         Street str = new Street(rs.getLong("steet_code"), rs.getString("street_name"));
         result.add(str);
        }
        return result;
    }

}
