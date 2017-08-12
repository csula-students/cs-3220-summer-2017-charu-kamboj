package edu.csula.jaxrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseResource {
	 public static final String database = "Lab7";
	    public static final String url = "jdbc:mysql://localhost/" + database;
	    public static final String username = "root";
	    public static final String password = "charu";

    public DatabaseResource() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch( ClassNotFoundException e ) {
            throw new IllegalStateException(e);
        }
    }

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}