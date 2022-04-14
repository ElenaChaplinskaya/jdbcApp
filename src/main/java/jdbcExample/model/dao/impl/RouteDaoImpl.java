package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.RouteDao;
import jdbcExample.model.entity.Route;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    @Override
    public void create(Route route) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into route (departure_id, arrival_id, departure, arrival) values (?,?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, route.getDeparture_id());
            statement.setInt(2, route.getArrival_id());
            statement.setString(3, route.getDeparture());
            statement.setString(4, route.getArrival());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Route> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Route> routes = new ArrayList<>();
        String sql = "select * from route";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Route route = new Route();
                route.setDeparture_id(rs.getInt(1));
                route.setArrival_id(rs.getInt(2));
                route.setDeparture(rs.getString(3));
                route.setArrival(rs.getString(4));
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;
    }

    @Override
    public Route getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from route where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Route route = new Route();
                route.setDeparture_id(rs.getInt(1));
                route.setArrival_id(rs.getInt(2));
                route.setDeparture(rs.getString(3));
                route.setArrival(rs.getString(4));

                return route;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Route route) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update route set departure_id=?, arrival_id=?, departure=?, arrival=? where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, route.getDeparture_id());
            statement.setInt(2, route.getArrival_id());
            statement.setString(3, route.getDeparture());
            statement.setString(4, route.getArrival());
            statement.setInt(5, route.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Route route) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete from route where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, route.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Route getByDeparture(String departure) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from route where departure =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, departure);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt(1));
                route.setDeparture(rs.getString(2));
                return route;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Route getByArrival(String arrival) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from route where arrival =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, arrival);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Route route = new Route();
                route.setId(rs.getInt(1));
                route.setArrival(rs.getString(2));
                return route;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
