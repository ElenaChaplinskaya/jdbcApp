package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.TicketDao;;
import jdbcExample.model.entity.Ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDao {
    @Override
    public void create(Ticket ticket) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into ticket (route_id, order_id, passport_data) values (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, ticket.getRoute_id());
            statement.setInt(2, ticket.getOrder_id());
            statement.setString(3, ticket.getPassport_data());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Ticket> tickets = new ArrayList<>();
        String sql = "select * from ticket";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setRoute_id(rs.getInt(1));
                ticket.setOrder_id(rs.getInt(2));
                ticket.setPassport_data(rs.getString(3));
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    @Override
    public Ticket getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from ticket where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt(1));
                ticket.setRoute_id(rs.getInt(2));
                ticket.setOrder_id(rs.getInt(3));
                ticket.setPassport_data(rs.getString(4));
                return ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Ticket ticket) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update airplane set route_id=?, order_id=?, passport_data=? where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, ticket.getRoute_id());
            statement.setInt(2, ticket.getOrder_id());
            statement.setString(3, ticket.getPassport_data());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Ticket ticket) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete from ticket where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, ticket.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ticket getByRoute_id(int route_id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from ticket where route_id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, route_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt(1));
                ticket.setRoute_id(rs.getInt(2));
                ticket.setOrder_id(rs.getInt(3));
                ticket.setPassport_data(rs.getString(4));
                return ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ticket getByOrder_id(int order_id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from ticket where order_id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, order_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt(1));
                ticket.setRoute_id(rs.getInt(2));
                ticket.setOrder_id(rs.getInt(3));
                ticket.setPassport_data(rs.getString(4));
                return ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Ticket getByPassport_data(String passport_data) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from ticket where passport_data =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, passport_data);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Ticket ticket = new Ticket();
                ticket.setId(rs.getInt(1));
                ticket.setRoute_id(rs.getInt(2));
                ticket.setOrder_id(rs.getInt(3));
                ticket.setPassport_data(rs.getString(4));
                return ticket;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
