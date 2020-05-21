package db;

import config.XMLConfigurationProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnectionManager {
    private static String user = new XMLConfigurationProvider().getValue("user");
    private static String pass = new XMLConfigurationProvider().getValue("password");
    private static String ssl = new XMLConfigurationProvider().getValue("ssl");

    public static Connection getConnection()throws SQLException{
        String url = "jdbc:postgresql://localhost/auto-moto";
        Properties prop = new Properties();
        prop.setProperty("user",user);
        prop.setProperty("password",pass);
        prop.setProperty("ssl",ssl);

        Connection conn = DriverManager.getConnection(url,prop);
        return conn;
    }
}
