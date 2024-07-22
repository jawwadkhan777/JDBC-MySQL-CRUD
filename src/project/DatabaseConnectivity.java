package project;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnectivity {
    static Connection connection = null;

    //establishing connection with database
    public static Connection connect() {
        try (FileInputStream in = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(in);

            String url = props.getProperty("db.url");
            String username = props.getProperty("db.username");
            String password = props.getProperty("db.password");

            connection = DriverManager.getConnection(url, username, password);
//            System.out.println("Database connected successfully!!!");

        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println(e.getMessage());
        }
        return connection;
    }
}
