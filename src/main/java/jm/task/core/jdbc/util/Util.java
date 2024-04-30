package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Util {
    // реализуйте настройку соеденения с БД
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost/maven";
            String username = "root";
            String password = "";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                System.out.println("Connection to Store DB succesfull!");
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");

            System.out.println(ex);

        }
    }
}