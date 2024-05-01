package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends Util implements UserService {

    //Connection connection = getConnection();
    Connection connection = getConnection();

//    static final String DATABASE_URL = "jdbc:mysql://localhost/maven";
//    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//
//    static final String USER = "root";
//    static final String PASSWORD = "";
    public void createUsersTable() throws ClassNotFoundException, SQLException {
            Util s = new Util();
          //  Connection connection = null;
            Statement statement = null;
            try {
                //connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                statement = s.getConnection().createStatement();

                String SQL = "CREATE TABLE maven.Users " +
                        "(id INTEGER not NULL AUTO_INCREMENT, " +
                        " name VARCHAR(45), " +
                        " lastName VARCHAR (45), " +
                        " age INTEGER, " +
                        " PRIMARY KEY (id))";

                statement.executeUpdate(SQL);
                System.out.println("Table successfully created...");
            } finally {
                if(statement!=null){
                    statement.close();
                }
                if(connection!=null){
                    connection.close();
                }
            }
    }

    public void dropUsersTable() throws ClassNotFoundException, SQLException {
        Util s = new Util();
        //Connection connection = null;
        Statement statement = null;
        try {
          //  System.out.println("Registering JDBC driver...");
          //  Class.forName(JDBC_DRIVER);

        //    System.out.println("Creating connection to database...");
        //    connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

           // System.out.println("Removing table in selected database...");
            //statement = connection.createStatement();
            statement = s.getConnection().createStatement();

            String SQL = "DROP TABLE maven.Users";
            //String SQL = "DELETE FROM Users";

            statement.executeUpdate(SQL);
            System.out.println("Table successfully removed...");
        } catch (SQLException e) {
            e.getStackTrace();
        }finally {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException, ClassNotFoundException {
        Util s = new Util();

     //   Class.forName(JDBC_DRIVER);
       // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/maven", "root", "");

        String query = "INSERT INTO maven.Users (name, lastName, age) VALUES (?, ?, ?)";
        //String query = "INSERT INTO Users (name, lastName, age) VALUES (name, lastName, age)";
        PreparedStatement preparedStatement = s.getConnection().prepareStatement(query);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, lastName);
        preparedStatement.setInt(3, age);

        int affectedRows = preparedStatement.executeUpdate();

      //  Statement statement =  connection.createStatement();
      //  statement.execute("INSERT INTO Users (name, lastName, age) VALUES (name, lastName, age)");

//        PreparedStatement prep = null;
//        String sql = "INSERT INTO User (id, name, lastName, age) VALUES (?, ?, ?, ?)";
//
//
//        try {
//            prep =  connection.prepareStatement(sql);
//            //User user = new User();
//            prep.setInt(1, 2);
//            prep.setString(2,name);
//            prep.setString(3, lastName);
//            prep.setLong(4, age);
//
//
//
//            prep.executeUpdate();
//        } catch (SQLException e) {
//            e.getStackTrace();
//        } finally {
//            if (prep != null) {
//                prep.close();
//            }
//            if (connection != null) {
//                connection.close();
//            }
//        }
    }

    public void removeUserById(long id) throws ClassNotFoundException, SQLException {
        Util s = new Util();
     //   Class.forName(JDBC_DRIVER);
        //Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/maven", "root", "");

        String query = "DELETE FROM Users WHERE id = " + id;
        //String query = "INSERT INTO Users (name, lastName, age) VALUES (name, lastName, age)";
        PreparedStatement preparedStatement = s.getConnection().prepareStatement(query);

        //preparedStatement.setInt(3, age);

        int affectedRows = preparedStatement.executeUpdate();
    }

    public List<User> getAllUsers() throws SQLException {
        Util s = new Util();
        List<User> users = new ArrayList<>();

        String sql = "SELECT name, lastName, age FROM Users";

        Statement statement = null;
        try {
            statement =  s.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
               // user.setId(resultSet.getLong("id"));
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

    public void cleanUsersTable() throws SQLException, ClassNotFoundException {
        //Connection connection = null;
        Util s = new Util();
        Statement statement = null;
        try {
            System.out.println("Registering JDBC driver...");
        //    Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
        //    connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

            System.out.println("Removing table in selected database...");
            statement = s.getConnection().createStatement();

            String SQL = "DELETE FROM Users";

            statement.executeUpdate(SQL);
            System.out.println("Table successfully removed...");
        }finally {
            if(statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
}
