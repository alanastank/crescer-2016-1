package br.com.cwi.aulas.aula3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class PessoaDao implements IPessoa {

    private static final Logger LOGGER = Logger.getLogger(Run.class.getName());

    @Override
    public void insert(Pessoa pessoa) {
        String INSERT = "INSERT INTO PESSOA (ID_PESSOA, NM_PESSOA) "
                + "VALUES ((SELECT MAX(ID_PESSOA) + 1 FROM PESSOA), ?)";
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement prepareStatement = connection.prepareStatement(INSERT)) {
            prepareStatement.setString(1, pessoa.getNome());
            prepareStatement.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        String UPDATE = "UPDATE PESSOA SET NM_PESSOA = ? WHERE ID_PESSOA = ?";
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement prepareStatement = connection.prepareStatement(UPDATE)) {
            prepareStatement.setString(1, pessoa.getNome());
            prepareStatement.setLong(2, pessoa.getId());
            prepareStatement.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        String DELETE = "DELETE FROM PESSOA WHERE ID_PESSOA = ?";
        try (final Connection connection = ConnectionUtils.getConnection();
                final PreparedStatement prepareStatement = connection.prepareStatement(DELETE)) {
            prepareStatement.setLong(1, pessoa.getId());
            prepareStatement.executeUpdate();
        } catch (final SQLException e) {
            LOGGER.severe(e.getMessage());
        }
    }

    @Override
    public List<Pessoa> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> findNome(String nome
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PessoaDao() {
    }
}
