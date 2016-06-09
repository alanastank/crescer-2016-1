package br.com.cwi.aulas.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectRun {

    public static void main(String[] args) {

        /* final String ddl = "CREATE TABLE PESSOA ("
                + " ID_PESSOA NUMBER(19,0) NOT NULL, "
                + " NM_PESSOA VARCHAR2(50) NOT NULL, "
                + " PRIMARY KEY (ID_PESSOA) "
                + ")";

        final String dml = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA)" + "VALUES (1, 'ALANA')"; */
        final String query = "SELECT * FROM PESSOA";
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                /* statement.executeUpdate(ddl);
                statement.executeUpdate(dml); */
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("NM_PESSOA"));
                    }
                    resultSet.close();
                } catch (final SQLException e) {
                    System.err.format("SQLException: %s", e);
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
