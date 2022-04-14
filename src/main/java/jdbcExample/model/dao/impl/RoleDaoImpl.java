package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.RoleDao;
import jdbcExample.model.entity.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Override
    public void create(Role role) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into role(name) values (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, role.getName());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Role> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Role> roles = new ArrayList<>();
        String sql = "select * from role";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt(1));
                role.setName(rs.getString(2));
                roles.add(role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roles;
    }

    @Override
    public Role getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from role where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt(1));
                role.setName(rs.getString(2));

                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Role getByName(String name) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from role where name =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt(1));
                role.setName(rs.getString(2));

                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Role role) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update role set name=? where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, role.getName());
            statement.setInt(2, role.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Role role) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete * from role where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, role.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
