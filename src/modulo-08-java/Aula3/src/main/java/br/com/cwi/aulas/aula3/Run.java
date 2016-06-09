package br.com.cwi.aulas.aula3;

import static java.awt.Event.INSERT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Run {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    public static void main(String[] args) {

        String INSERT = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";

        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement prepareStatement = connection.prepareStatement(INSERT)) {
            prepareStatement.setString(1, "Alanaa");
            prepareStatement.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }
}
