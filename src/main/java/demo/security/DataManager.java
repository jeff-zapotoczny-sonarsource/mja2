package demo.security;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataManager {

    public DataManager() {
        // no need to do anything here
    }

    public String taintedSQL(Connection connection, String user) throws SQLException {
        String query = "SELECT userid FROM users WHERE username = '" + user + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet.getString(1);
    }

    public String hotspotSQL(Connection connection, String user) throws Exception {
        Statement statement = null;
        statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("select userid from users WHERE username=" + user);
        return rs.getString(1);
    }

    public void storeData(String input) {
        // Empty (fake) sink
        // To be a real sink this should normally build an SQL query from the input
        // parameter
    }

}
