package br.com.cwi.aulas.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {

    private final static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private final static String user = "CRESCER16";
    private final static String pass = "CRESCER16";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
