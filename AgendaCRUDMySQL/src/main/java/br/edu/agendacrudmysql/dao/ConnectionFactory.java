package br.edu.agendacrudmysql.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DAO/Infra: centraliza a criação de conexões JDBC. Mantém URL/usuário/senha em
 * um único lugar (facilita manutenção).
 */
public final class ConnectionFactory {

    /**
     * Correção para o erro: Public Key Retrieval is not allowed Parâmetro
     * adicionado: allowPublicKeyRetrieval=true Útil especialmente em MySQL 8+
     * usando caching_sha2_password em ambiente local/laboratório.
     */
    private static final String URL =
    "jdbc:mysql://localhost:3306/agenda_db? useSSL  = false & allowPublicKeyRetrieval = true & serverTimezone = UTC";
// Ajuste conforme seu ambiente
private static final String USER = "root";
    private static final String PASS = "SUA_SENHA_AQUI";

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
