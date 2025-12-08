package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Greivin
 */

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/ProduccionAgricola";
    private static final String USER = "root";
    private static final String PASSWORD = "Root123@";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static ConexionBD instance;
    
    private ConexionBD() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConexionBD getInstance() {
        if (instance == null) {
            instance = new ConexionBD();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}