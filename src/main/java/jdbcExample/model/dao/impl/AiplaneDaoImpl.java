package jdbcExample.model.dao.impl;

import jdbcExample.DataSource;
import jdbcExample.model.dao.AirplaneDao;
import jdbcExample.model.entity.Airplane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AiplaneDaoImpl implements AirplaneDao {

    @Override
    public void create(Airplane airplane) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "insert into airplane (aircompany_id, name) values (?,?)";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, airplane.getAircompany_id());
            statement.setString(2, airplane.getModel());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Airplane> getAll() {
        Connection connection = DataSource.getInstance().getConnection();
        List<Airplane> airplanes = new ArrayList<>();
        String sql = "select * from airplane";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(rs.getInt(1));
                airplane.setAircompany_id(rs.getInt(2));
                airplane.setModel(rs.getString(3));
                airplanes.add(airplane);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return airplanes;
    }

    @Override
    public Airplane getById(int id) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from airplane where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(rs.getInt(1));
                airplane.setAircompany_id(rs.getInt(2));
                airplane.setModel(rs.getString(3));
                return airplane;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Airplane airplane) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "update airplane set aircompany_id=?, model=? where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, airplane.getAircompany_id());
            statement.setString(2, airplane.getModel());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Airplane airplane) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "delete from airplane where id =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setInt(1, airplane.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Airplane getByModel(String model) {
        Connection connection = DataSource.getInstance().getConnection();
        String sql = "select * from airplane where model =?";
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, model);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(rs.getInt(1));
                airplane.setAircompany_id(rs.getInt(2));
                airplane.setModel(rs.getString(3));
                return airplane;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
