package br.com.crescer.exerciciosaula3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
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
        query = query.toLowerCase();
        if (query.matches("^select\\s")) {
            try (final Connection connection = ConnectionUtils.getConnection()) {
                try (final Statement statement = connection.createStatement()) {
                    try (final ResultSet resultSet = statement.executeQuery(query)) {
                        ResultSetMetaData rsmd = resultSet.getMetaData();
                        int numColunas = rsmd.getColumnCount();
                        for (int i = 0; i < numColunas; i++) {
                            System.out.print(rsmd.getColumnName(i) + "\t");
                        }
                        System.out.println("\n");
                        while (resultSet.next()) {
                            System.out.println(resultSet.getLong("ID_PESSOA") + "\t" + resultSet.getString("NM_PESSOA"));
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
}
