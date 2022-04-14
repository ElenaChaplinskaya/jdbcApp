package jdbcExample;

import jdbcExample.model.dao.RoleDao;
import jdbcExample.model.dao.UserDao;
import jdbcExample.model.dao.impl.RoleDaoImpl;
import jdbcExample.model.dao.impl.UserDaoImpl;
import jdbcExample.model.entity.Role;
import jdbcExample.model.entity.User;

import java.sql.*;
import java.util.List;

public class JdbcApp {

    public static void main(String[] args) throws SQLException {

        RoleDao roleDao = new RoleDaoImpl();
        List<Role> roles = roleDao.getAll();

        UserDao userDao = new UserDaoImpl();

        List<User> users = userDao.getAll();
        userDao.create(new User(5, "User5", 1));
        userDao.getById(6);
        userDao.update(new User(6, "User", 1));
        userDao.delete(userDao.getById(6));

    }
}
