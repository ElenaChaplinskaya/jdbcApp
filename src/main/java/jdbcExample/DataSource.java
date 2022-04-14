package jdbcExample;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
    private static DataSource instance = new DataSource();
    private ComboPooledDataSource comboPooledDataSource;

    private DataSource() {
        Properties prop = new Properties();
        comboPooledDataSource = new ComboPooledDataSource();

        try (InputStream inputStream = new FileInputStream("src/main/resources/db.properties")) {
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl(prop.getProperty("db.url"));
        comboPooledDataSource.setUser(prop.getProperty("db.user"));
        comboPooledDataSource.setPassword(prop.getProperty("db.password"));

        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setMaxPoolSize(20);
    }

    public static DataSource getInstance(){
        return instance;
    }

    public Connection getConnection() {
        try {
            return comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
