package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.UserDao;
import jdbcExample.model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void create(User user) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into user (name, role_id) values (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getRole_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setRole_id(rs.getInt(3));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from user where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setRole_id(rs.getInt(3));

                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(User user) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update user set name=? where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, user.getName());
            statement.setInt(2, user.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete from user where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getByName(String name) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from user where name =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
