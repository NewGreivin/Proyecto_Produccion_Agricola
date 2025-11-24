package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Greivin
 */

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/produccion_agricola";
    private static final String USER = "root";
    private static final String PASSWORD = "Root123@";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    private static ConexionBD instance;
    private Connection connection;

    private ConexionBD() {
        try {
            Class.forName(DRIVER);
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ConexionBD getInstance() {
        try {
            if (instance == null || instance.getConnection().isClosed()) {
                instance = new ConexionBD();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}