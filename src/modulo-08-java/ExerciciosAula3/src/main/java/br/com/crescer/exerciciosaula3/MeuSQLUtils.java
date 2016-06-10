package br.com.crescer.exerciciosaula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class MeuSQLUtils {

    // TODO: Implementar ExerciciosAula2 e utilizar método de MeuReaderUtils
    public void lerArquivoSQLEExecutar(String arquivo) {
        if (new File(arquivo).exists()) {
            try {
                final Reader reader = new FileReader(arquivo);
                final BufferedReader bufferedReader = new BufferedReader(reader);
                String line = null;
                while (true) {
                    line = bufferedReader.readLine();
                    if (line != null) {
                        System.out.println(line);
                        executarQuery(line);
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!arquivo.matches(
                "^.*\\.(sql|SQL)$")) {
            System.err.println("Esse arquivo não pode ser executado pois não possui extensão .sql");
        } else {
            System.err.println("O arquivo não existe.");
        }
    }

    public void executarQuery(String query) {
        try (final Connection connection = ConnectionUtils.getConnection()) {
            try (final Statement statement = connection.createStatement()) {
                try (final ResultSet resultSet = statement.executeQuery(query)) {
                    System.out.println("Comando executado com sucesso.");
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

    public void executarQueryEMostrarColunasELinhasSeForSelect(String query) {
        if (query.toLowerCase().matches("^select\\s.*$")) {
            try (final Connection connection = ConnectionUtils.getConnection()) {
                try (final Statement statement = connection.createStatement()) {
                    try (final ResultSet resultSet = statement.executeQuery(query)) {
                        ResultSetMetaData rsmd = resultSet.getMetaData();
                        int numColunas = rsmd.getColumnCount();
                        for (int i = 1; i <= numColunas; i++) {
                            System.out.print(rsmd.getColumnName(i) + "\t");
                        }
                        System.out.println("\n");
                        while (resultSet.next()) {
                            for (int i = 1; i <= numColunas; i++) {
                                System.out.print(resultSet.getString(i) + "\t\t");
                            }
                            System.out.println("\n");
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
        } else {
            executarQuery(query);
        }
    }

    public void importarCSV(String arquivo) {
        if (new File(arquivo).exists()) {
            try {
                final Reader reader = new FileReader(arquivo);
                final BufferedReader bufferedReader = new BufferedReader(reader);
                String line = null;
                String INSERT = "INSERT INTO PESSOA (IdPessoa, NomePessoa) VALUES (?,?)";
                while (true) {
                    line = bufferedReader.readLine();
                    if (line != null) {
                        String[] partes = line.split(";");
                        try (final Connection connection = ConnectionUtils.getConnection();
                                final PreparedStatement prepareStatement = connection.prepareStatement(INSERT)) {
                            prepareStatement.setString(1, partes[0]);
                            prepareStatement.setString(2, partes[1]);
                            prepareStatement.executeUpdate();
                        } catch (final SQLException e) {
                            System.err.format("SQLException: %s", e);
                        }
                    } else {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (!arquivo.matches(
                "^.*\\.(csv|CSV)$")) {
            System.err.println("Esse arquivo não pode ser executado pois não possui extensão .csv");
        } else {
            System.err.println("O arquivo não existe.");
        }
    }
}
