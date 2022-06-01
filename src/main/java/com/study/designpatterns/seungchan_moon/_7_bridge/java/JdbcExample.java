package com.study.designpatterns.seungchan_moon._7_bridge.java;

import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) throws ClassNotFoundException {
        // 브릿지의 구체적인 곳이다. (org.h2.Driver)
        Class.forName("org.h2.Driver");

        // 브릿지의 추상화쪽에 해당한다.
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {
            String sql = "CREATE TABLE ACCOUNT" +
                    "(id INTEGER NOT NULL , " +
                    "email VARCHAR(255), " +
                    "password VARCHAR(255), " +
                    "PRIMARY KEY (id)" +
                    ")";

            Statement statement = connection.createStatement();
            statement.execute(sql);

//            PreparedStatement statement1 = connection.prepareStatement(sql);
//            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
