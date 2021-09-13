package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Requests {
    private static final ConnectionUtil connectionUtil = new ConnectionUtil();

    public static Integer getIdByName(String param) {
        Integer integer = null;
        try (PreparedStatement preparedStatement = connectionUtil.getPreparedStatement
                ("SELECT field FROM table WHERE param = ?")) {
            preparedStatement.setString(1, param);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                integer = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return integer;
    }

    public static void deleteSomethingById(int param) {
        try (PreparedStatement preparedStatement = connectionUtil.getPreparedStatement
                ("DELETE FROM table WHERE param = ?")) {
            preparedStatement.setInt(1, param);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateSomethingById(int param) {
        try (PreparedStatement preparedStatement = connectionUtil.getPreparedStatement
                ("UPDATE table SET field = new_value WHERE param = ?")) {
            preparedStatement.setInt(1, param);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
