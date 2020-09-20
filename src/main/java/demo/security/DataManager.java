package demo.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {

    ProprietaryFramework framework;

    public DataManager() {
        framework = new ProprietaryFramework();
    }

    public String getUser(Connection connection, String user) throws SQLException {
        /* try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement
                        .executeQuery("SELECT userid FROM users WHERE username = '" + user + "'");) {
            return resultSet.getString(1);
        } */
    }

    public String getThing(Connection connection, String param) throws SQLException {
        /* try (Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select thing from others WHERE param=" + param);) {
            return rs.getString(1);
        } */
    }

    public void storeData(String data) {
        framework.storeData(data);
    }
}
