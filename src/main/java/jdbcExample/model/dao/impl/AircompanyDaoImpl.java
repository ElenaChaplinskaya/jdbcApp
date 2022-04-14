package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.AircompanyDao;
import jdbcExample.model.entity.Aircompany;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircompanyDaoImpl implements AircompanyDao {

    @Override
    public void create(Aircompany aircompany) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into aircompany (name) values (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, aircompany.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Aircompany> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Aircompany> aircompanies = new ArrayList<>();
        String sql = "select * from aircompany";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Aircompany aircompany = new Aircompany();
                aircompany.setName(rs.getString(1));
                aircompanies.add(aircompany);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aircompanies;
    }

    @Override
    public Aircompany getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from aircompany where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Aircompany aircompany = new Aircompany();
                aircompany.setName(rs.getString(1));
                return aircompany;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Aircompany aircompany) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update aircompany set name=? where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, aircompany.getName());
            statement.setInt(2, aircompany.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Aircompany aircompany) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete from aircompany where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, aircompany.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aircompany getByName(String name) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from aircompany where name =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Aircompany aircompany = new Aircompany();
                aircompany.setName(rs.getString(1));
                return aircompany;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
