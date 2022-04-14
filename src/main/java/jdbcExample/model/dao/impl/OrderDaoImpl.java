package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.OrderDao;
import jdbcExample.model.entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void create(Order order) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into order (number, order_date, user_id) values (?,?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, order.getNumber());
            statement.setString(2, order.getOrder_date());
            statement.setInt(3, order.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Order> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Order> orders = new ArrayList<>();
        String sql = "select * from order ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setNumber(rs.getInt(1));
                order.setOrder_date(rs.getString(2));
                order.setUser_id(rs.getInt(3));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Order getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from order where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setNumber(rs.getInt(1));
                order.setOrder_date(rs.getString(2));
                order.setUser_id(rs.getInt(3));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Order order) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update order set number =?, order_date = ?, user_id =? where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, order.getNumber());
            statement.setString(2, order.getOrder_date());
            statement.setInt(3, order.getUser_id());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Order order) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete from order where id=?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getByNumber(int number) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from order where number = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, number);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));
                order.setNumber(rs.getInt(2));
                order.setOrder_date(rs.getString(3));
                order.setUser_id(rs.getInt(4));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Order getByOrder_date(String order_date) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from order where order_date =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, order_date);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));
                order.setNumber(rs.getInt(2));
                order.setOrder_date(rs.getString(3));
                order.setUser_id(rs.getInt(4));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Order getByUser_id(int user_id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from order where user_id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, user_id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getInt(1));
                order.setNumber(rs.getInt(2));
                order.setOrder_date(rs.getString(3));
                order.setUser_id(rs.getInt(4));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
