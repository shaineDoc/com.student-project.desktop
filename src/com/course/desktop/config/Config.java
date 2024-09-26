package com.course.desktop.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static final String DB_URL = "db.url";
    public static final String DB_LOGIN = "db.login";
    public static final String DB_PASSWORD = "db.password";

    private static Properties properties = new Properties();

    public synchronized static String getProperty(String name) {
        if (properties.isEmpty()) {
            // открытие файла как поток байтов с целью дальнейшего его закрытия (необходимое условие) :
            try (InputStream is = Config.class.getClassLoader()
                    .getResourceAsStream("dao.properties")) {
                properties.load(is);

            } catch (Exception ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }

        }
        return properties.getProperty(name);
    }
}
