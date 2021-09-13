package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static rest.PropHelper.properties;

public class ConnectionUtil {
    private ConnectionUtil connectionUtil = null;
    private Connection connection;

    public ConnectionUtil() {
        try {
            String DATABASE_URL = String.valueOf(properties.get("db.url"));
            String USER = String.valueOf(properties.get("db.user"));
            String PASS = String.valueOf(properties.get("db.password"));
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASS);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        if (Objects.isNull(connectionUtil)) {
            connectionUtil = new ConnectionUtil();
        }
        return connection;
    }

    public PreparedStatement getPreparedStatement(String SQL) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return preparedStatement;
    }

}
