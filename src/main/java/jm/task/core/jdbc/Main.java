package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // реализуйте алгоритм здесь

            //UserDao userDao = new UserDaoJDBCImpl();
            UserService userDao = new UserServiceImpl();
//
            userDao.createUsersTable();
//            userDao.dropUsersTable();
//            userDao.createUsersTable();
//
//            userDao.saveUser("Name1", "LastName1", (byte) 20);
//            userDao.saveUser("Name2", "LastName2", (byte) 25);
//            userDao.saveUser("Name3", "LastName3", (byte) 31);
//            userDao.saveUser("Name4", "LastName4", (byte) 38);
//
//            userDao.removeUserById(2);
//            userDao.getAllUsers();
//            userDao.cleanUsersTable();

    }
}
