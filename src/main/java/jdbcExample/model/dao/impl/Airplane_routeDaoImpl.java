package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.Airplane_routeDao;
import jdbcExample.model.entity.Airplane_route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Airplane_routeDaoImpl implements Airplane_routeDao {

    @Override
    public void create(Airplane_route airplane_route) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into airplane_route (airplane_id, routes_id) values (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, airplane_route.getAirplane_id());
            statement.setInt(2, airplane_route.getRoutes_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airplane_route> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Airplane_route> airplane_routes = new ArrayList<>();
        String sql = "select * from airplane_route ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airplane_route airplane_route = new Airplane_route();
                airplane_route.setAirplane_id(rs.getInt(1));
                airplane_route.setRoutes_id(rs.getInt(2));
                airplane_routes.add(airplane_route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airplane_route getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from airplane_route where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airplane_route airplane_route = new Airplane_route();
                airplane_route.setAirplane_id(rs.getInt(1));
                airplane_route.setRoutes_id(rs.getInt(2));
                return airplane_route;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Airplane_route airplane_route) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update airplane_route set airplane_id =?, routes_id = ? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, airplane_route.getAirplane_id());
            statement.setInt(2, airplane_route.getRoutes_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Airplane_route airplane_route) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete from airplane_route where id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, airplane_route.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airplane_route getByAirplane_id(int airplane_id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from airplane_id where number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, airplane_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airplane_route airplane_route = new Airplane_route();
                airplane_route.setAirplane_id(rs.getInt(1));
                airplane_route.setRoutes_id(rs.getInt(2));
                return airplane_route;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Airplane_route getByRoutes_id(int routes_id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from routes_id where number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, routes_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airplane_route airplane_route = new Airplane_route();
                airplane_route.setAirplane_id(rs.getInt(1));
                airplane_route.setRoutes_id(rs.getInt(2));
                return airplane_route;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
