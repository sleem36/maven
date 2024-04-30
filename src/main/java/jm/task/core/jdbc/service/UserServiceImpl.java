package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {

    UserDaoJDBCImpl dop = new UserDaoJDBCImpl(); // добавил
    //Connection connection = getConnection();
    Connection connection = getConnection();
    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        PreparedStatement prep = null;
        String sql = "INSERT INTO User (name, lastName, age) VALUES (name, lastName, age)";
        try {
            prep =  connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            if (prep != null) {
                prep.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        String sql = "SELECT name, lastName, age FROM User";

        Statement statement = null;
        try {
            statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));

                users.add(user);
            }

        } catch (SQLException e) {
            e.getStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


        return users;
    }

    public void cleanUsersTable() {

    }
}
