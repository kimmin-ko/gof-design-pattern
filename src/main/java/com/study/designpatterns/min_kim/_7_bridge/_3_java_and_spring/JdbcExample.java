package com.study.designpatterns.min_kim._7_bridge._3_java_and_spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.h2.Driver"); // loaded driver (Implementation)

        // ------------- RDBMS의 Driver가 바뀌더라도 아래 코드는 변경되지 않는다. -------------
        try (Connection conn = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "")) {

            String sql = "CREATE TABLE ACCOUNT " +
                    "(" +
                    "   id INTEGER NOT NULL," +
                    "   email VARCHAR(255)," +
                    "   password VARCHAR(255)," +
                    "   PRIMARY KEY(id)" +
                    ")";

            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
